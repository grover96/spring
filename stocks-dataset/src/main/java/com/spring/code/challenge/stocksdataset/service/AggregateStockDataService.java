package com.spring.code.challenge.stocksdataset.service;

import com.spring.code.challenge.stocksdataset.domain.AggregateStockData;
import com.spring.code.challenge.stocksdataset.repository.AggregateStockDataRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class AggregateStockDataService {

    private AggregateStockDataRepository aggregateStockDataRepository;

    public AggregateStockDataService(AggregateStockDataRepository aggregateStockDataRepository) {
        this.aggregateStockDataRepository = aggregateStockDataRepository;
    }

    public AggregateStockData findStockInformationByDate(Date date, String symbol) {
        return aggregateStockDataRepository.findStockInformationByDate(date, symbol);
    }
}
