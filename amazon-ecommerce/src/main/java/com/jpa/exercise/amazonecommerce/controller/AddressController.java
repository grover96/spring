package com.jpa.exercise.amazonecommerce.controller;

import com.jpa.exercise.amazonecommerce.domain.Address;
import com.jpa.exercise.amazonecommerce.service.AddressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts/{id}/addresses")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public Iterable<Address> getAllByAccountId(@PathVariable("id") Long id){
        return addressService.getAllByAccountId(id);
    }

    @GetMapping(value = "/{address_id}")
    public Address getById(@PathVariable("id") Long accountId, @PathVariable("address_id") Long id){
        return addressService.getById(id, accountId);
    }

    @PostMapping
    public @ResponseBody Address create(@RequestBody Address address, @PathVariable("id") Long id) {
        return addressService.create(address, id);
    }

    @PutMapping(value = "/{address_id}")
    public @ResponseBody Address update(@PathVariable("address_id") Long id, @PathVariable("id") Long accountId, @RequestBody Address address){
        return addressService.update(id, accountId, address);
    }

    @DeleteMapping(value = "/{address_id}")
    public void delete(@PathVariable("id") Long accountId, @PathVariable("address_id") Long id){
        addressService.delete(id, accountId);
    }
}
