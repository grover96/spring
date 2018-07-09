package com.spring.code.challenge.stocksdataset.domain;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface AggregateStockData {

    @JsonGetter("maxPrice")
    float getMaxPrice();

    @JsonGetter("minPrice")
    float getMinPrice();

    @JsonGetter("sumOfVolume")
    int getSumOfVolume();

}
