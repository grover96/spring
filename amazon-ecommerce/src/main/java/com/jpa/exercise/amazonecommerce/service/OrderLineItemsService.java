package com.jpa.exercise.amazonecommerce.service;

import com.jpa.exercise.amazonecommerce.domain.Account;
import com.jpa.exercise.amazonecommerce.domain.OrderLineItems;
import com.jpa.exercise.amazonecommerce.domain.Orders;
import com.jpa.exercise.amazonecommerce.domain.Shipment;
import com.jpa.exercise.amazonecommerce.repository.AccountRepository;
import com.jpa.exercise.amazonecommerce.repository.OrderLineItemsRepository;
import com.jpa.exercise.amazonecommerce.repository.OrdersRepository;
import com.jpa.exercise.amazonecommerce.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderLineItemsService {

    private OrderLineItemsRepository orderLineItemsRepository;
    private ShipmentRepository shipmentRepository;
    private OrdersRepository ordersRepository;
    private AccountRepository accountRepository;

    public OrderLineItemsService(OrderLineItemsRepository orderLineItemsRepository, ShipmentRepository shipmentRepository, OrdersRepository ordersRepository, AccountRepository accountRepository) {
        this.orderLineItemsRepository = orderLineItemsRepository;
        this.shipmentRepository = shipmentRepository;
        this.ordersRepository = ordersRepository;
        this.accountRepository = accountRepository;
    }

    public Iterable<OrderLineItems> getAllByAccountIdAndShipmentIdAndOrderId(Long shipmentId, Long orderId, Long accountId){
        return orderLineItemsRepository.getAllByAccountIdAndShipmentIdAndOrderId(shipmentId, orderId, accountId);
    }

    public OrderLineItems getByAccountIdAndOrderIdAndShipmentIdAndId(Long accountId, Long orderId, Long shipmentId, Long orderLineItemsId){
        return orderLineItemsRepository.getByAccountIdAndOrderIdAndShipmentIdAndId(accountId, orderId, shipmentId, orderLineItemsId);
    }

    public OrderLineItems create(Long id, Long orderId, Long accountId, OrderLineItems orderLineItems) {
        Account account = accountRepository.findById(accountId).get();
        Shipment shipment = shipmentRepository.findById(id).get();
        Orders orders = ordersRepository.findById(orderId).get();
        orderLineItems.setAccount(account);
        orderLineItems.setShipment(shipment);
        orderLineItems.setOrder(orders);
        return orderLineItemsRepository.save(orderLineItems);
    }

    public OrderLineItems update(Long accountId, Long orderId, Long shipmentId, Long orderLineItemsId, OrderLineItems orderLineItems){
        Account account = accountRepository.findById(accountId).get();
        Shipment shipment = shipmentRepository.findById(shipmentId).get();
        Orders orders = ordersRepository.findById(orderId).get();
        OrderLineItems orderLineItemsById = orderLineItemsRepository.findById(orderLineItemsId).get();
        orderLineItems.setAccount(account);
        orderLineItems.setShipment(shipment);
        orderLineItems.setOrder(orders);
        orderLineItemsById.setPrice(orderLineItems.getPrice());
        orderLineItemsById.setQuantity(orderLineItems.getQuantity());
        orderLineItemsById.setTotalPrice(orderLineItems.getTotalPrice());
        return orderLineItemsRepository.save(orderLineItemsById);
    }

    public void delete(Long accountId, Long orderId, Long shipmentId, Long orderLineItemsId){
        OrderLineItems orderLineItems = orderLineItemsRepository.getByAccountIdAndOrderIdAndShipmentIdAndId(accountId, orderId, shipmentId, orderLineItemsId);
        orderLineItemsRepository.deleteById(orderLineItems.getId());
    }

}
