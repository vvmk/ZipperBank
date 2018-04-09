package io.zipcoder.controller;

import io.zipcoder.domain.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * project: zcwbank
 * package: io.zipcoder.controller
 * author: https://github.com/vvmk
 * date: 4/9/18
 */

@RestController
public class CustomerController {

    @RequestMapping(value = "/accounts/{accountId}/customer", method = GET)
    public ResponseEntity<Customer> getCustomerByAccountId(@PathVariable Long accountId) {
        return null;
    }

    @RequestMapping(value = "/customers", method = GET)
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        return null;
    }

    @RequestMapping(value = "/customers/{customerId}", method = GET)
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        return null;
    }

    @RequestMapping(value = "/customers", method = POST)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return null;
    }

    @RequestMapping(value = "/customers/{customerId}", method = PUT)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        return null;
    }
}
