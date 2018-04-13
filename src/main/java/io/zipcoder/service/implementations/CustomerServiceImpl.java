package io.zipcoder.service.implementations;

import io.zipcoder.domain.Customer;
import io.zipcoder.repository.CustomerRepository;
import io.zipcoder.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * project: zcwbank
 * package: io.zipcoder.service.implementations
 * author: https://github.com/vvmk
 * date: 4/9/18
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public ResponseEntity<Customer> getCustomerByAccountId(Long accountId) {
        return null;
    }

    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        return null;
    }

    public ResponseEntity<Customer> getCustomerById(Long customerId) {
        return null;
    }

    public ResponseEntity<Customer> createCustomer(Customer customer) {
        return null;
    }

    public ResponseEntity<Customer> updateCustomer(Customer customer, Long customerId) {
        return null;
    }

    public ResponseEntity deleteCustomerById(Long customerId) {
        return null;
    }
}
