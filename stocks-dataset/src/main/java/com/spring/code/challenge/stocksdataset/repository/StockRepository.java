package com.spring.code.challenge.stocksdataset.repository;

import com.spring.code.challenge.stocksdataset.domain.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
}