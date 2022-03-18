package io.bastrikov.customers.controllers;

import io.bastrikov.customers.services.CustomerService;
import io.bastrikov.customers.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/customer/save")
    public boolean saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
    @GetMapping("/customer/find/{id}")
    public Optional<Customer> findCustomerById(@PathVariable int id) {
        return customerService.findCustomerById(id);
    }
    @GetMapping("/customer/find")
    public List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }
    @GetMapping("/customer/delete/{id}")
    public boolean deleteCustomerById(@PathVariable int id){
        return customerService.removeCustomerById(id);
    }
    @GetMapping("/customer/generate")
    public String generateCustomers(){
        customerService.generate();
        return "customers were generated";
    }
}
