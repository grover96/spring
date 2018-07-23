package com.spring.code.challenge.stock.controller;

import com.spring.code.challenge.stock.controller.StockController;
import com.spring.code.challenge.stock.domain.Stock;
import com.spring.code.challenge.stock.service.StockService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(StockController.class)
public class StockControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
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

        System.out.println(when(stockService.save(any(List.class))).thenReturn(stocks));

//        List<Stock> exampleStock = Arrays.asList(
//                new Stock(1, "AMZN", 145.5f, 3000, Date.valueOf("2018-07-23")),
//                new Stock(1, "GOOG", 75.2f, 5000, Date.valueOf("2018-02-23")));

        String exampleStock = "{\"id\":\"1\",\"symbol\":\"AMZN\",\"price\":\"145.5\",\"volume\":\"3000\",\"date\":\"2018-02-23\"}";


        MvcResult result = mockMvc.perform(post("/stocks/load")
                .contentType(MediaType.APPLICATION_JSON).content(exampleStock))
                //.andExpect(jsonPath("$..symbol").exists())
                .andReturn();

        System.out.println("OVER HERE");

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

        verify(stockService, times(1)).save(any(List.class));

    }

}
