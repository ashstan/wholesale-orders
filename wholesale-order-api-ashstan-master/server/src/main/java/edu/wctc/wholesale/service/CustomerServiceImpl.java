package edu.wctc.wholesale.service;

import edu.wctc.wholesale.entity.Customer;
import edu.wctc.wholesale.exception.ResourceNotFoundException;
import edu.wctc.wholesale.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        customerRepository.findAll().forEach(list::add);
        return list;
    }

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(int customer_id) throws ResourceNotFoundException{
//        Optional<Customer> optional = customerRepository.findById(id);
//        return optional.orElseThrow(() -> new ResourceNotFoundException("Customer", "customer_id", Integer.toString(id)));
        return customerRepository.findById(customer_id).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", Integer.toString(customer_id)));
    }

    public Customer getCustomer(String name) throws ResourceNotFoundException {
        Optional<Customer> optional = customerRepository.findByName(name);
        if(optional.isPresent())
            return optional.get();
        else
            throw new ResourceNotFoundException("Customer", "name", name);
    }

}
