package com.jpa.exercise.amazonecommerce.repository;

import com.jpa.exercise.amazonecommerce.domain.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {
    Orders getByIdAndAccountId(Long id, Long accountId);
    List<Orders> findByAccountIdOrderByOrderDateAsc(Long id);
}
