package com.spring.code.challenge.stock.controller;

import com.spring.code.challenge.stock.ConfigSecurity;
import com.spring.code.challenge.stock.domain.Stock;
import com.spring.code.challenge.stock.service.StockService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StockController.class)
@ContextConfiguration(classes = {ConfigSecurity.class})
public class StockControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private StockService stockService;

    @InjectMocks
    private StockController stockController;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoadData() throws Exception {

        //create stocks
        Stock mockStock1 = new Stock();
        mockStock1.setPrice(146.6f);
        mockStock1.setSymbol("AMZN");
        mockStock1.setVolume(5000);

        Stock mockStock2 = new Stock();
        mockStock2.setPrice(16.6f);
        mockStock2.setSymbol("GOOG");
        mockStock2.setVolume(6000);

        List<Stock> stocks = new ArrayList<Stock>();
        stocks.add(mockStock1);
        stocks.add(mockStock2);

        when(stockService.save(any(List.class))).thenReturn(stocks);

        String exampleStock = "{\"id\":\"1\",\"symbol\":\"AMZN\",\"price\":\"145.5\",\"volume\":\"3000\",\"date\":\"2018-02-23\"}";

        MvcResult result = mockMvc.perform(post("/stocks/loader")
                .contentType(MediaType.APPLICATION_JSON).content(exampleStock))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        verify(stockService, times(1)).save(any(List.class));

    }
}
