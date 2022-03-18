package io.bastrikov.customers.services;

import io.bastrikov.customers.dao.AddressRepository;
import io.bastrikov.customers.dao.CustomerRepository;
import io.bastrikov.customers.models.Address;
import io.bastrikov.customers.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    AddressService addressService = new AddressService();

    Random random = new Random();

    public boolean saveCustomer(Customer customer) {
        customerRepository.save(customer);
        System.out.println("customer was created");
        return true;
    }

    public Optional<Customer> findCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findAllCustomers() {
        List<Customer> list = new ArrayList<>();
        Iterable<Customer> iterable= customerRepository.findAll();
        iterable.forEach(customer -> list.add(customer));
        return list;
    }

    public boolean removeCustomerById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) return false;
        else {
            customerRepository.deleteById(id);
            return true;
        }
    }

    public void generate() {
        List<Customer> customerList = generateCustomers();
        for(Customer customer: customerList) customerRepository.save(customer);
    }
    public List<Customer> generateCustomers(){
        int amount = 1000;
        List<String> firstNames = new ArrayList<>(Arrays.asList("John", "Martin", "Sarah", "Michael", "Bon", "Adam", "David"));
        List<String> lastNames = new ArrayList<>(Arrays.asList("Black", "Smith", "Holmes", "White", "Rowling", "Potter"));
        List<Address> addresses = addressService.generateAddresses();
        List<Customer> customerList = new LinkedList<>();
        for(int i = 1; i <= amount; i++) {
            int firstNameIndex = random.nextInt(firstNames.size());
            int lastNameIndex = random.nextInt(lastNames.size());
            int addressIndex = random.nextInt(addresses.size());
            String firstName = firstNames.get(firstNameIndex);
            String lastName = lastNames.get(lastNameIndex);
            Address address = addresses.get(addressIndex);

            Customer customer = new Customer(i, firstName, lastName, address.getId());
            customerList.add(customer);
        }
        return customerList;
    }

}
