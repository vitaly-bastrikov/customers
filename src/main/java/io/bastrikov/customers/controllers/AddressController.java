package io.bastrikov.customers.controllers;

import io.bastrikov.customers.dao.AddressRepository;
import io.bastrikov.customers.models.Address;
import io.bastrikov.customers.models.Customer;
import io.bastrikov.customers.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("/address/save")
    public boolean saveCustomer(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @GetMapping("/address/find/{id}")
    public Optional<Address> findCustomerById(@PathVariable int id) {
        return addressService.findAddressById(id);
    }
    @GetMapping("/address/find")
    public List<Address> findAllCustomers(){
        return addressService.findAllAddresses();
    }
    @GetMapping("/address/delete/{id}")
    public boolean deleteCustomerById(@PathVariable int id){
        return addressService.removeAddressById(id);
    }
    @GetMapping("/address/generate")
    public String generateAddress(){
        addressService.generate();
        return "addresses were generated";
    }
}
