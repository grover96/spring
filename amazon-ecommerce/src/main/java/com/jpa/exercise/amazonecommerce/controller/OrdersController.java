package com.jpa.exercise.amazonecommerce.controller;

import com.jpa.exercise.amazonecommerce.domain.OrderDetails;
import com.jpa.exercise.amazonecommerce.domain.Orders;
import com.jpa.exercise.amazonecommerce.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts/{id}/orders")
public class OrdersController {
    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public Iterable<Orders> findByAccountIdOrderByOrderDateAsc(@PathVariable("id") Long id){
        return ordersService.findByAccountIdOrderByOrderDateAsc(id);
    }

    @GetMapping(value = "/{order_id}")
    public Orders getById(@PathVariable("order_id") Long id, @PathVariable("id") Long accountId){
        return ordersService.getById(id, accountId);
    }

    @GetMapping(value = "/{order_id}/details")
    public OrderDetails getOrderDetails(@PathVariable("order_id") Long id, @PathVariable("id") Long accountId, OrderDetails orderDetails){
        return ordersService.getOrderDetails(id, accountId, orderDetails);
    }

    @PostMapping
    public @ResponseBody Orders create(@RequestBody Orders orders, @PathVariable("id") Long id) {
        return ordersService.create(orders, id);
    }

    @PutMapping(value = "/{order_id}")
    public @ResponseBody Orders update(@PathVariable("order_id") Long id, @PathVariable("id") Long accountId, @RequestBody Orders orders){
        return ordersService.update(id, accountId, orders);
    }

    @DeleteMapping(value = "/{order_id}")
    public void delete(@PathVariable("id") Long accountId, @PathVariable("order_id") Long id){
        ordersService.delete(id, accountId);
    }
}
