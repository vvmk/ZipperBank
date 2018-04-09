package io.zipcoder.controller;

import io.zipcoder.domain.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

/**
 * project: zcwbank
 * package: io.zipcoder.controller
 * author: https://github.com/vvmk
 * date: 4/9/18
 */

@RestController
public class CustomerController {

    public ResponseEntity<Customer> getCustomerByAccountId(Long accountId) {
        return null;
    }

    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        return null;
    }

    public ResponseEntity<Customer> getCustomerById(Long id) {
        return null;
    }

    public ResponseEntity<Customer> createCustomer(Customer customer) {
        return null;
    }

    public ResponseEntity<Customer> updateCustomer(Customer customer) {
        return null;
    }
}
