package com.jpa.exercise.amazonecommerce.service;

import com.jpa.exercise.amazonecommerce.domain.Account;
import com.jpa.exercise.amazonecommerce.domain.Address;
import com.jpa.exercise.amazonecommerce.domain.Shipment;
import com.jpa.exercise.amazonecommerce.repository.AccountRepository;
import com.jpa.exercise.amazonecommerce.repository.AddressRepository;
import com.jpa.exercise.amazonecommerce.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {

    private ShipmentRepository shipmentRepository;
    private AccountRepository accountRepository;
    private AddressRepository addressRepository;

    public ShipmentService(ShipmentRepository shipmentRepository, AccountRepository accountRepository,
                           AddressRepository addressRepository) {
        this.shipmentRepository = shipmentRepository;
        this.accountRepository = accountRepository;
        this.addressRepository = addressRepository;
    }

    public Iterable<Shipment> getAllByAccountIdAndShippingAddressId(Long accountId, Long addressId){
        return shipmentRepository.getAllByAccountIdAndShippingAddressId(accountId, addressId);
    }

    public Shipment getByAccountIdAndShippingAddressIdAndId(Long accountId, Long addressId, Long shipmentId){
        return shipmentRepository.getByAccountIdAndShippingAddressIdAndId(accountId, addressId, shipmentId);
    }

    public Shipment create(Shipment shipment, Long accountId, Long addressId) {
        Account account = accountRepository.findById(accountId).get();
        Address address = addressRepository.findById(addressId).get();
        shipment.setAccount(account);
        shipment.setShippingAddress(address);
        return shipmentRepository.save(shipment);
    }

    public Shipment update(Long accountId, Long addressId, Long shipmentId, Shipment shipment){
        Account account = accountRepository.findById(accountId).get();
        Address address = addressRepository.findById(addressId).get();
        Shipment shipmentById = shipmentRepository.findById(shipmentId).get();
        shipmentById.setAccount(account);
        shipmentById.setShippingAddress(address);
        shipmentById.setDeliveryDate(shipment.getDeliveryDate());
        shipmentById.setShippedDate(shipment.getShippedDate());
        return shipmentRepository.save(shipmentById);
    }

    public void delete(Long accountId, Long addressId, Long shipmentId){
        Shipment shipment = shipmentRepository.getByAccountIdAndShippingAddressIdAndId(accountId, addressId, shipmentId);
        shipmentRepository.deleteById(shipment.getId());
    }
}
