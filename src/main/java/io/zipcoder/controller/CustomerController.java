package io.zipcoder.controller;

import io.zipcoder.domain.Customer;
import io.zipcoder.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/accounts/{accountId}/customer", method = GET)
    public ResponseEntity<Customer> getCustomerByAccountId(@PathVariable("accountId") Long accountId) {
        return customerService.getCustomerByAccountId(accountId);
    }

    @RequestMapping(value = "/customers", method = GET)
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/customers/{customerId}", method = GET)
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @RequestMapping(value = "/customers", method = POST)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @RequestMapping(value = "/customers/{customerId}", method = PUT)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("customerId") Long customerId) {
        return customerService.updateCustomer(customer, customerId);
    }

    @RequestMapping(value = "/customers/{customerId}", method = DELETE)
    public ResponseEntity deleteCustomer(@PathVariable("customerId") Long customerId) {
        return customerService.deleteCustomerById(customerId);
    }
}
