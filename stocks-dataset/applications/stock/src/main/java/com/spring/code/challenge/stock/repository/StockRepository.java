package com.spring.code.challenge.stock.repository;

import com.spring.code.challenge.stock.domain.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
}