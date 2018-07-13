package com.jpa.exercise.amazonecommerce.repository;

import com.jpa.exercise.amazonecommerce.domain.Shipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends CrudRepository<Shipment, Long> {
    Shipment getByAccountIdAndShippingAddressIdAndId(Long accountId, Long addressId, Long shipmentId);
    List<Shipment> getAllByAccountIdAndShippingAddressId(Long accountId, Long addressId);
}
