package io.bastrikov.customers.dao;

import io.bastrikov.customers.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
