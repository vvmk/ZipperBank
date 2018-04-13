package io.zipcoder.service.interfaces;

import io.zipcoder.domain.Customer;
import org.springframework.http.ResponseEntity;

/**
 * project: zcwbank
 * package: io.zipcoder.service.interfaces
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
public interface CustomerService {
    ResponseEntity<Customer> getCustomerByAccountId(Long accountId);

    ResponseEntity<Iterable<Customer>> getAllCustomers();

    ResponseEntity<Customer> getCustomerById(Long customerId);

    ResponseEntity<Customer> createCustomer(Customer customer);

    ResponseEntity<Customer> updateCustomer(Customer customer, Long customerId);

    ResponseEntity deleteCustomerById(Long customerId);
}
