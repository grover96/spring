package com.spring.code.challenge.stock.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.code.challenge.stock.domain.AggregateStockData;
import com.spring.code.challenge.stock.domain.Stock;
import com.spring.code.challenge.stock.service.AggregateStockDataService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.Date;

@RestController
@RequestMapping("/stocks")
public class AggregateStockDataController {

    private AggregateStockDataService aggregateStockDataService;

    public AggregateStockDataController(AggregateStockDataService aggregateStockDataService) {
        this.aggregateStockDataService = aggregateStockDataService;
    }

    @GetMapping
    public Iterable<Stock> findAll(){
        return aggregateStockDataService.findAll();
    }

    @GetMapping(value = {"/{symbol}"})
    public AggregateStockData findIdBySymbol(@PathVariable("symbol") String symbol) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String stockKeyUrl = "http://localhost:8080/stockSymbols/" + symbol;

        ResponseEntity<String> response = restTemplate.getForEntity(stockKeyUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode companySymbol = root.path("symbol");
        JsonNode companyId = root.path("id");

        System.out.println(companyId);
        System.out.println(companySymbol);

        return aggregateStockDataService.findSymbolById(companyId.asLong());
    }

    @GetMapping(value = {"/{symbol}/{date}"})
    public AggregateStockData getStockInfo(@PathVariable("symbol") String symbol,
                                           @PathVariable("date") @DateTimeFormat(pattern = "dd-MM-yyyy") String date) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        String stockKeyUrl = "http://localhost:8080/stockSymbols/" + symbol;

        ResponseEntity<String> response = restTemplate.getForEntity(stockKeyUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode companySymbol = root.path("symbol");
        JsonNode companyId = root.path("id");

        System.out.println(companyId);
        System.out.println(companySymbol);

        return aggregateStockDataService.findStockInformationByDate(Date.valueOf(date), companyId.asLong());
    }


}
