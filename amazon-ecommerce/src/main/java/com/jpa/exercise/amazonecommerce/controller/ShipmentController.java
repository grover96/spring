package com.jpa.exercise.amazonecommerce.controller;

import com.jpa.exercise.amazonecommerce.domain.Shipment;
import com.jpa.exercise.amazonecommerce.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts/{account_id}/addresses/{address_id}/shipments")
public class ShipmentController {

    private ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping
    public Iterable<Shipment> getAllByAccountIdAndShippingAddressId(@PathVariable("account_id") Long accountId, @PathVariable("address_id") Long addressId){
        return shipmentService.getAllByAccountIdAndShippingAddressId(accountId, addressId);
    }

    @GetMapping(value = "/{shipment_id}")
    public Shipment getByAccountIdAndShippingAddressIdAndId(@PathVariable("account_id") Long accountId, @PathVariable("address_id") Long addressId, @PathVariable("shipment_id") Long shipmentId){
        return shipmentService.getByAccountIdAndShippingAddressIdAndId(accountId, addressId, shipmentId);
    }

    @PostMapping
    public @ResponseBody
    Shipment create(@RequestBody Shipment shipment, @PathVariable("account_id") Long id, @PathVariable("address_id") Long addressId) {
        return shipmentService.create(shipment, id, addressId);
    }

    @PutMapping(value = "/{shipment_id}")
    public @ResponseBody Shipment update(@PathVariable("account_id") Long accountId, @PathVariable("address_id") Long addressId, @PathVariable("shipment_id") Long shipmentId, @RequestBody Shipment shipment){
        return shipmentService.update(accountId, addressId, shipmentId, shipment);
    }

    @DeleteMapping(value = "/{shipment_id}")
    public void delete(@PathVariable("account_id") Long accountId, @PathVariable("address_id") Long addressId, @PathVariable("shipment_id") Long shipmentId){
        shipmentService.delete(accountId, addressId, shipmentId);
    }
}
