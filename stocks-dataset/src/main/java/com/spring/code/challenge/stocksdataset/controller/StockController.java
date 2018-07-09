package com.spring.code.challenge.stocksdataset.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.code.challenge.stocksdataset.domain.Stock;
import com.spring.code.challenge.stocksdataset.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/load")
    public void load() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Stock> stock = mapper.readValue(new URL("https://bootcamp-training-files.cfapps.io/week2/week2-stocks.json"), new TypeReference<List<Stock>>() {});
            stockService.save(stock);
            System.out.println("******************************");
            System.out.println("Information stored to database");
            System.out.println("******************************");
        } catch (IOException e) {
            System.out.println("Unable to save users: " + e.getMessage());
        }
    }
}
