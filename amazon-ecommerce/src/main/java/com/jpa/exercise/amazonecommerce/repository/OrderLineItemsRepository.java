package com.jpa.exercise.amazonecommerce.repository;

import com.jpa.exercise.amazonecommerce.domain.Address;
import com.jpa.exercise.amazonecommerce.domain.OrderLineItems;
import com.jpa.exercise.amazonecommerce.domain.Shipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineItemsRepository extends CrudRepository<OrderLineItems, Long> {
    OrderLineItems getByAccountIdAndOrderIdAndShipmentIdAndId(Long accountId, Long orderId, Long shipmentId, Long orderLineItemsId);
    List<OrderLineItems> getAllByAccountIdAndShipmentIdAndOrderId(Long shipmentId, Long orderId, Long accountId);
}
