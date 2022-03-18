package io.bastrikov.customers.services;

import io.bastrikov.customers.dao.AddressRepository;
import io.bastrikov.customers.models.Address;
import io.bastrikov.customers.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    Random random = new Random();

    public boolean saveAddress(Address address) {
        addressRepository.save(address);
        return true;
    }

    public Optional<Address> findAddressById(int id) {
        return addressRepository.findById(id);
    }

    public List<Address> findAllAddresses() {
        List<Address> list = new ArrayList<>();
        Iterable<Address> iterable= addressRepository.findAll();
        iterable.forEach(customer -> list.add(customer));
        return list;
    }

    public boolean removeAddressById(int id) {
        Optional<Address> customer = addressRepository.findById(id);
        if (!customer.isPresent()) return false;
        else {
            addressRepository.deleteById(id);
            return true;
        }
    }
    public void generate() {
        List<Address> addressList = generateAddresses();
        for(Address address: addressList) addressRepository.save(address);
    }

    public List<Address> generateAddresses() {
        List<String> countries = new ArrayList<>(Arrays.asList("US", "Canada", "Japan", "UK", "Russia"));
        List<String> cities = new ArrayList<>(Arrays.asList("New York", "Moscow", "Toronto", "Tokyo", "Vancouver", "London"));
        List<String> streets = new ArrayList<>(Arrays.asList("Hesperus Rd", "Princess Ave", "5th Ave", "Holmes Ave", "Western Rd", "South Bridge"));
        List<Integer> streetsNumbers = new ArrayList<>(Arrays.asList(23, 123, 139, 4, 51, 27, 98, 18, 6));

        int addressCount = 30;
        List<Address> list = new LinkedList<>();
        for (int i = 0; i < addressCount; i++) {
            int countryIndex = random.nextInt(countries.size());
            int cityIndex = random.nextInt(cities.size());
            int streetIndex = random.nextInt(cities.size());
            int streetNumberIndex = random.nextInt(streetsNumbers.size());
            String country = countries.get(countryIndex);
            String city = cities.get(cityIndex);
            String street = streets.get(streetIndex);
            int streetNumber = streetsNumbers.get(streetNumberIndex);
            list.add(new Address(i, country, city, street, streetNumber));
        }
        return list;
    }
}
