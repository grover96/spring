package com.jpa.exercise.amazonecommerce.service;

import com.jpa.exercise.amazonecommerce.domain.Account;
import com.jpa.exercise.amazonecommerce.domain.Address;
import com.jpa.exercise.amazonecommerce.repository.AccountRepository;
import com.jpa.exercise.amazonecommerce.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;
    private AccountRepository accountRepository;

    public AddressService(AddressRepository addressRepository, AccountRepository accountRepository) {
        this.addressRepository = addressRepository;
        this.accountRepository = accountRepository;
    }

    public Iterable<Address> getAllByAccountId(Long id){
        return addressRepository.findByAccountId(id);
    }

    public Address getById(Long id, Long accountId){
        return addressRepository.getByIdAndAccountId(id, accountId);
    }

    public Address create(Address address, Long id) {
        Account account = accountRepository.findById(id).get();
        address.setAccount(account);
        return addressRepository.save(address);
    }

    public Address update(Long id, Long accountId, Address address){
        Address addressById = addressRepository.findById(accountId).get();
        addressById.setStreet(address.getStreet());
        addressById.setApt(address.getApt());
        addressById.setCity(address.getCity());
        addressById.setState(address.getState());
        addressById.setZipCode(address.getZipCode());
        addressById.setCountry(address.getCountry());
        return addressRepository.save(addressById);
    }

    public void delete(Long id, Long accountId){
        Address address = addressRepository.getByIdAndAccountId(id, accountId);
        addressRepository.deleteById(address.getId());
    }

}
