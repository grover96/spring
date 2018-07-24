package com.spring.code.challenge.stock.service;

import com.spring.code.challenge.stock.domain.AggregateStockData;
import com.spring.code.challenge.stock.domain.Stock;
import com.spring.code.challenge.stock.repository.AggregateStockDataRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AggregateServiceUnitTest {

    @Mock
    private AggregateStockDataRepository aggregateStockDataRepository;

    @InjectMocks
    private AggregateStockDataService aggregateStockDataService;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAggData() throws IOException {

        //create stocks
        AggregateStockData mockStock1 = new AggregateStockData(146.6f, 59.6f, 5000);

        when(aggregateStockDataRepository.findStockInformationByDate(any(Date.class), any(String.class))).thenReturn(mockStock1);

        AggregateStockData aggregateStockData = aggregateStockDataService.findStockInformationByDate(null, null);

        //verify the save
        assertEquals(146.6f, aggregateStockData.getMaxPrice());
    }
}
