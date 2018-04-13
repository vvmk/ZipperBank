package io.zipcoder.service.implementations;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.CustomerRepository;
import io.zipcoder.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * project: zcwbank
 * package: io.zipcoder.service
 * author: https://github.com/vvmk
 * date: 4/9/18
 */

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepo;
    private CustomerRepository customerRepo;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepo, CustomerRepository customerRepo) {
        this.accountRepo = accountRepo;
        this.customerRepo = customerRepo;
    }

    public ResponseEntity<Account> getAccountById(Long accountId) {
        Account account = accountRepo.findById(accountId).orElse(new Account());
        return new ResponseEntity<>(account, OK);
    }

    public ResponseEntity<Iterable<Account>> getAccountsByCustomerId(Long customerId) {
        Iterable<Account> accounts = accountRepo.findAllByCustomer_Id(customerId);
        return new ResponseEntity<>(accounts, OK);
    }

    public ResponseEntity<Account> createAccount(Account account, Long customerId) {
        try {
            Customer customer = customerRepo.findById(customerId).orElseThrow(Exception::new);
            account.setCustomer(customer);
            Account returnedAccount = accountRepo.save(account);
            return new ResponseEntity<>(returnedAccount, CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new Account(), BAD_REQUEST);
        }
    }

    public ResponseEntity<Account> updateAccount(Account account, Long accountId) {
        return null;
    }

    public ResponseEntity deleteAccountById(Long accountId) {
        return null;
    }

    public ResponseEntity<Iterable<Account>> getAllAccounts() {
        return null;
    }
}
