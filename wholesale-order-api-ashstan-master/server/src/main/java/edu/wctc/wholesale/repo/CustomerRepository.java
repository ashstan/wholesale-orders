package edu.wctc.wholesale.repo;

import edu.wctc.wholesale.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    //select a single customer
    Optional<Customer> findByName(String name);
}
