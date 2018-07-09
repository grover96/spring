package com.spring.code.challenge.stocksdataset.controller;

import com.spring.code.challenge.stocksdataset.domain.AggregateStockData;
import com.spring.code.challenge.stocksdataset.service.AggregateStockDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/stock")
public class AggregateStockDataController {

    private AggregateStockDataService aggregateStockDataService;

    public AggregateStockDataController(AggregateStockDataService aggregateStockDataService) {
        this.aggregateStockDataService = aggregateStockDataService;
    }

    @GetMapping(value = {"/{symbol}/{date}"})
    public AggregateStockData getStockInfo(@PathVariable("symbol") String symbol,
                                           @PathVariable("date") String date) {
        return aggregateStockDataService.findStockInformationByDate(Date.valueOf(date), symbol);
    }
}
