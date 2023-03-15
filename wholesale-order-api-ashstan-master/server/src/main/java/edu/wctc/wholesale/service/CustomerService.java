package edu.wctc.wholesale.service;

import edu.wctc.wholesale.entity.Customer;
import edu.wctc.wholesale.exception.ResourceNotFoundException;

public interface CustomerService {
    Customer getCustomer (String name);

    Customer getCustomer(int customer_id) throws ResourceNotFoundException;
}
