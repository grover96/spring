package com.spring.code.challenge.stock.controller;

import com.spring.code.challenge.stock.domain.AggregateStockData;
import com.spring.code.challenge.stock.domain.Stock;
import com.spring.code.challenge.stock.service.AggregateStockDataService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Date;

@RestController
@RequestMapping("/stocks")
public class  AggregateStockDataController {

    private AggregateStockDataService aggregateStockDataService;

    public AggregateStockDataController(AggregateStockDataService aggregateStockDataService) {
        this.aggregateStockDataService = aggregateStockDataService;
    }

    @GetMapping
    public Iterable<Stock> findAll(){
        return aggregateStockDataService.findAll();
    }

    @GetMapping(value = {"/{symbol}"})
    public AggregateStockData findBySymbol (@PathVariable("symbol") String symbol) throws IOException {
        return aggregateStockDataService.findSymbolById(symbol);
    }

    @GetMapping(value = {"/{symbol}/{date}"})
    public AggregateStockData getStockInfo(@PathVariable("symbol") String symbol,
                                           @PathVariable("date") @DateTimeFormat(pattern = "dd-MM-yyyy") String date) throws IOException {
        return aggregateStockDataService.findStockInformationByDate(Date.valueOf(date), symbol);
    }

}
