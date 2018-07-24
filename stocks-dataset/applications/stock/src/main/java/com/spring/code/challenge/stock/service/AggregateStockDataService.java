package com.spring.code.challenge.stock.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.code.challenge.stock.domain.AggregateStockData;
import com.spring.code.challenge.stock.domain.Stock;
import com.spring.code.challenge.stock.repository.AggregateStockDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.Date;

@Service
public class AggregateStockDataService {

    @Autowired
    RestTemplate restTemplate;

    private AggregateStockDataRepository aggregateStockDataRepository;

    public AggregateStockDataService(AggregateStockDataRepository aggregateStockDataRepository) {
        this.aggregateStockDataRepository = aggregateStockDataRepository;
    }

    public Iterable<Stock> findAll(){
        return aggregateStockDataRepository.findAll();
    }

    public AggregateStockData findSymbolById(String symbol) throws IOException {
        ResponseEntity<String> response = restTemplate.getForEntity("//symbols/stockSymbols/" + symbol, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode companyId = root.path("id");

        return aggregateStockDataRepository.findStockInformation(companyId.asText());
    }

    public AggregateStockData findStockInformationByDate(Date date, String symbol) throws IOException  {
        ResponseEntity<String> response = restTemplate.getForEntity("//symbols/stockSymbols/" + symbol, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode companyId = root.path("id");
        return aggregateStockDataRepository.findStockInformationByDate(date, companyId.asText());
    }
}
