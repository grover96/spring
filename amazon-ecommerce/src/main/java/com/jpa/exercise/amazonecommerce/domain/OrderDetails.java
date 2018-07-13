package com.jpa.exercise.amazonecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class OrderDetails {

    @JsonIgnore
    private Account account;
    private int orderNumber;
    private Address shippingAddress;
    private float totalPrice;
    private List<Shipment> shipment;

    public OrderDetails() {}

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Shipment> getShipment() {
        return shipment;
    }

    public void setShipment(List<Shipment> shipment) {
        this.shipment = shipment;
    }
}
