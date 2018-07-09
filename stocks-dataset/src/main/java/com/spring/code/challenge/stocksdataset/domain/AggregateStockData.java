package com.spring.code.challenge.stocksdataset.domain;

import com.fasterxml.jackson.annotation.JsonGetter;

//public interface AggregateStockData {
//
//    @JsonGetter("maxPrice")
//    float getMaxPrice();
//
//    @JsonGetter("minPrice")
//    float getMinPrice();
//
//    @JsonGetter("sumOfVolume")
//    int getSumOfVolume();
//
//}

public class AggregateStockData {

    private float maxPrice;
    private float minPrice;
    private long sumOfVolume;

    public AggregateStockData(float maxPrice, float minPrice, long sumOfVolume) {
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.sumOfVolume = sumOfVolume;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }

    public long getSumOfVolume() {
        return sumOfVolume;
    }

    public void setSumOfVolume(long sumOfVolume) {
        this.sumOfVolume = sumOfVolume;
    }
}
