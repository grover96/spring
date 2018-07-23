package com.spring.code.challenge.stock.service;

import com.spring.code.challenge.stock.domain.AggregateStockData;
import com.spring.code.challenge.stock.domain.Stock;
import com.spring.code.challenge.stock.repository.AggregateStockDataRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;

@Service
public class AggregateStockDataService {

    private AggregateStockDataRepository aggregateStockDataRepository;

    public AggregateStockDataService(AggregateStockDataRepository aggregateStockDataRepository) {
        this.aggregateStockDataRepository = aggregateStockDataRepository;
    }

    public Iterable<Stock> findAll(){
        return aggregateStockDataRepository.findAll();
    }

    public AggregateStockData findSymbolById(Long symbolId) throws IOException {
        return aggregateStockDataRepository.findStockInformation(symbolId.toString());

    }

    public AggregateStockData findStockInformationByDate(Date date, Long symbol) {
        return aggregateStockDataRepository.findStockInformationByDate(date, symbol.toString());
    }
}
