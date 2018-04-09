package io.zipcoder.controller;

import io.zipcoder.domain.Account;
import io.zipcoder.service.interfaces.AccountService;
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
public class AccountController {
    private AccountService acctService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.acctService = accountService;
    }

    @RequestMapping(value = "/accounts", method = GET)
    public ResponseEntity<Iterable<Account>> getAllAccounts() {
        return acctService.getAllAccounts();
    }

    @RequestMapping(value = "/accounts/{accountId}", method = GET)
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
        return null;
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = GET)
    public ResponseEntity<Iterable<Account>> getAccountsByCustomerId(@PathVariable Long customerId) {
        return null;
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = POST)
    public ResponseEntity<Account> createAccount(@RequestBody Account account, @PathVariable Long customerId) {
        return null;
    }

    @RequestMapping(value = "/accounts/{accountId}", method = PUT)
    public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathVariable Long accountId) {
        return null;
    }

    @RequestMapping(value = "/accounts/{accountId}", method = DELETE)
    public ResponseEntity deleteAccountById(@PathVariable Long accountId) {
        return null;
    }
}
