package com.spring.code.challenge.stocksdataset.service;

import com.spring.code.challenge.stocksdataset.domain.Stock;
import com.spring.code.challenge.stocksdataset.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    private StockRepository stockRepository;
    private List<Stock> addStocks = new ArrayList<Stock>();

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Iterable<Stock> findAll() {
        return stockRepository.findAll();
    }

    public Iterable<Stock> save(List<Stock> stockInfo) {
        for (int i = 0; i < stockInfo.size(); i++) {
            Stock stock = new Stock();
            stock.setSymbol(stockInfo.get(i).getSymbol());
            stock.setPrice(stockInfo.get(i).getPrice());
            stock.setVolume(stockInfo.get(i).getVolume());
            stock.setDate(stockInfo.get(i).getDate());
            addStocks.add(stock);
        }
        return stockRepository.saveAll(addStocks);
    }
}