package com.spring.code.challenge.stocksdataset.repository;

import com.spring.code.challenge.stocksdataset.domain.AggregateStockData;
import com.spring.code.challenge.stocksdataset.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface AggregateStockDataRepository extends JpaRepository<Stock, Long> {

    @Query(value = "SELECT MAX(stocks.price) AS maxPrice, MIN(stocks.price) AS minPrice, SUM(stocks.volume) AS sumOfVolume FROM Stock stocks WHERE stocks.date = :date AND stocks.symbol = :symbol")
    AggregateStockData findStockInformationByDate(@Param("date") Date date, @Param("symbol") String symbol);

}
