package com.spring.code.challenge.stock.repository;

import com.spring.code.challenge.stock.domain.AggregateStockData;
import com.spring.code.challenge.stock.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface AggregateStockDataRepository extends CrudRepository<Stock, Long> {

    @Query(value = "select new com.spring.code.challenge.stock.domain.AggregateStockData(MAX(stocks.price) AS maxPrice, MIN(stocks.price) AS minPrice, SUM(stocks.volume) AS sumOfVolume) " +
            "FROM Stock stocks WHERE stocks.date = :date AND stocks.symbol = :symbol")
    AggregateStockData findStockInformationByDate(@Param("date") Date date, @Param("symbol") String symbol);

    @Query(value = "select new com.spring.code.challenge.stock.domain.AggregateStockData(MAX(stocks.price) AS maxPrice, MIN(stocks.price) AS minPrice, SUM(stocks.volume) AS sumOfVolume) " +
            "FROM Stock stocks WHERE stocks.symbol = :symbol")
    AggregateStockData findStockInformation(@Param("symbol") String symbol);

//  Ex. without a constructor expression
//  @Query(value = "SELECT MAX(stocks.price) AS maxPrice, MIN(stocks.price) AS minPrice, SUM(stocks.volume) AS sumOfVolume " +
//          "FROM Stock stocks WHERE stocks.date = :date AND stocks.symbol = :symbol")
//  AggregateStockData findStockInformationByDate(@Param("date") Date date, @Param("symbol") String symbol);
}
