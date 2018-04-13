package io.zipcoder.service.implementations;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.CustomerRepository;
import io.zipcoder.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

/**
 * project: zcwbank
 * package: io.zipcoder.service.implementations
 * author: https://github.com/vvmk
 * date: 4/9/18
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepo;
    private AccountRepository accountRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepo, AccountRepository accountRepo) {
        this.customerRepo = customerRepo;
        this.accountRepo = accountRepo;
    }

    public ResponseEntity<Customer> getCustomerByAccountId(Long accountId) {
        try {
            Account returnedAccount = accountRepo.findById(accountId).orElseThrow(Exception::new);
            Customer foundCustomer = returnedAccount.getCustomer();
            return new ResponseEntity<>(foundCustomer, OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Customer(), BAD_REQUEST);
        }
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
