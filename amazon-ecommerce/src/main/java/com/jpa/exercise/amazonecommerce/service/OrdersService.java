package com.jpa.exercise.amazonecommerce.service;

import com.jpa.exercise.amazonecommerce.domain.Account;
import com.jpa.exercise.amazonecommerce.domain.OrderDetails;
import com.jpa.exercise.amazonecommerce.domain.Orders;
import com.jpa.exercise.amazonecommerce.repository.AccountRepository;
import com.jpa.exercise.amazonecommerce.repository.AddressRepository;
import com.jpa.exercise.amazonecommerce.repository.OrdersRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private OrdersRepository ordersRepository;
    private AccountRepository accountRepository;
    private AddressRepository addressRepository;

    public OrdersService(OrdersRepository ordersRepository, AccountRepository accountRepository, AddressRepository addressRepository) {
        this.ordersRepository = ordersRepository;
        this.accountRepository = accountRepository;
        this.addressRepository = addressRepository;
    }

    public Iterable<Orders> findByAccountIdOrderByOrderDateAsc(Long id){
        return ordersRepository.findByAccountIdOrderByOrderDateAsc(id);
    }

    public Orders getById(Long id, Long accountId){
        return ordersRepository.getByIdAndAccountId(id, accountId);
    }

    public OrderDetails getOrderDetails(Long id, Long accountId, OrderDetails orderDetails){
        Account account = accountRepository.findById(accountId).get();
        Orders orders = ordersRepository.findById(id).get();
        orderDetails.setAccount(account);
        orderDetails.setShippingAddress(orders.getShippingAddress());
        orderDetails.setOrderNumber(orders.getOrderNumber());
        //orderDetails.setShipment(orders.getOrderLineItems().getShipment());
        orderDetails.setTotalPrice(orders.getTotalPrice());
        return orderDetails;
    }

    public Orders create(Orders orders, Long id) {
        Account account = accountRepository.findById(id).get();
        orders.setAccount(account);
        return ordersRepository.save(orders);
    }

    public Orders update(Long id, Long accountId, Orders orders){
        Account account = accountRepository.findById(accountId).get();
        Orders ordersById = ordersRepository.findById(id).get();
        ordersById.setAccount(account);
        ordersById.setOrderNumber(orders.getOrderNumber());
        ordersById.setOrderDate(orders.getOrderDate());
        ordersById.setTotalPrice(orders.getTotalPrice());
        return ordersRepository.save(ordersById);
    }

    public void delete(Long id, Long accountId){
        Orders orders = ordersRepository.getByIdAndAccountId(id, accountId);
        ordersRepository.deleteById(orders.getId());
    }
}
