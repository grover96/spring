package com.spring.code.challenge.stock.service;

import com.spring.code.challenge.stock.domain.Stock;
import com.spring.code.challenge.stock.repository.StockRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StockServiceUnitTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockService stockService;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveStocks(){

        //create stocks
        Stock mockStock1 = new Stock();
        mockStock1.setPrice(146.6f);
        mockStock1.setSymbol("AMZN");
        mockStock1.setVolume(5000);

        Stock mockStock2 = new Stock();
        mockStock2.setPrice(16.6f);
        mockStock2.setSymbol("GOOG");
        mockStock2.setVolume(6000);

        when(stockRepository.saveAll(any(Iterable.class))).thenReturn(Arrays.asList(mockStock1, mockStock2));

        //save the contact
        List<Stock> stock = stockService.save(null);

        //verify the save
        assertEquals("AMZN", stock.get(0).getSymbol());
        assertEquals("GOOG", stock.get(1).getSymbol());
        assertEquals(5000, stock.get(0).getVolume());
        assertEquals(6000, stock.get(1).getVolume());

    }

}
