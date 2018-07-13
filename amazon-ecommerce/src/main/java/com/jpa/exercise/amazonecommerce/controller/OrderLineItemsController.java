package com.jpa.exercise.amazonecommerce.controller;

import com.jpa.exercise.amazonecommerce.domain.OrderLineItems;
import com.jpa.exercise.amazonecommerce.service.OrderLineItemsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts/{account_id}/orders/{order_id}/shipments/{shipment_id}/orderLineItem")
public class OrderLineItemsController {

    private OrderLineItemsService orderLineItemsService;

    public OrderLineItemsController(OrderLineItemsService orderLineItemsService) {
        this.orderLineItemsService = orderLineItemsService;
    }

    @GetMapping
    public Iterable<OrderLineItems> getAllByAccountIdAndShipmentIdAndOrderId(@PathVariable("shipment_id") Long shipmentId, @PathVariable("order_id") Long orderId, @PathVariable("account_id") Long accountId){
        return orderLineItemsService.getAllByAccountIdAndShipmentIdAndOrderId(shipmentId, orderId, accountId);
    }

    @GetMapping(value = "/{orderLineItems_id}")
    public OrderLineItems getByAccountIdAndOrderIdAndShipmentIdAndId(@PathVariable("account_id") Long accountId, @PathVariable("order_id") Long orderId,
                                                                     @PathVariable("shipment_id") Long shipmentId, @PathVariable("orderLineItems_id") Long orderLineItemsId){
        return orderLineItemsService.getByAccountIdAndOrderIdAndShipmentIdAndId(accountId, orderId, shipmentId, orderLineItemsId);
    }

    @PostMapping
    public @ResponseBody
    OrderLineItems create(@RequestBody OrderLineItems orderLineItems, @PathVariable("shipment_id") Long shipmentId, @PathVariable("order_id") Long orderId, @PathVariable("account_id") Long accountId) {
        return orderLineItemsService.create(accountId, orderId, shipmentId, orderLineItems);
    }

    @PutMapping(value = "/{orderLineItems_id}")
    public @ResponseBody OrderLineItems update(@PathVariable("shipment_id") Long shipmentId, @PathVariable("order_id") Long orderId, @PathVariable("orderLineItems_id") Long orderLineItemsId, @PathVariable("account_id") Long accountId, @RequestBody OrderLineItems orderLineItems){
        return orderLineItemsService.update(accountId, orderId, shipmentId, orderLineItemsId, orderLineItems);
    }

    @DeleteMapping(value = "/{orderLineItems_id}")
    public void delete(@PathVariable("shipment_id") Long shipmentId, @PathVariable("order_id") Long orderId, @PathVariable("orderLineItems_id") Long orderLineItemsId, @PathVariable("account_id") Long accountId){
        orderLineItemsService.delete(accountId, orderId, shipmentId, orderLineItemsId);
    }
}
