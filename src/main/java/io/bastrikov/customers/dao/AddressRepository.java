package io.bastrikov.customers.dao;

import io.bastrikov.customers.models.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
