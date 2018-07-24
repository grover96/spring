package com.spring.code.challenge.stock.controller;

import com.spring.code.challenge.stock.ConfigSecurity;
import com.spring.code.challenge.stock.domain.AggregateStockData;
import com.spring.code.challenge.stock.service.AggregateStockDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StockController.class)
@ContextConfiguration(classes = ConfigSecurity.class)
public class AggregateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AggregateStockDataService aggregateStockDataService;

    @InjectMocks
    private AggregateStockDataController aggregateStockDataController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindSymbol() throws Exception {

        AggregateStockData aggregateStockData = new AggregateStockData(146.6f, 45.6f, 4030);

        when(aggregateStockDataService.findSymbolById(any(String.class))).thenReturn(aggregateStockData);

        String symbol = "AMZN";
        mockMvc.perform(get("/{symbol}", symbol))
                .andExpect(status().isOk());
    }
}
