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
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/accounts", method = GET)
    public ResponseEntity<Iterable<Account>> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @RequestMapping(value = "/accounts/{accountId}", method = GET)
    public ResponseEntity<Account> getAccountById(@PathVariable("accountId") Long accountId) {
        return accountService.getAccountById(accountId);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = GET)
    public ResponseEntity<Iterable<Account>> getAccountsByCustomerId(@PathVariable("customerId") Long customerId) {
        return accountService.getAccountsByCustomerId(customerId);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = POST)
    public ResponseEntity<Account> createAccount(@RequestBody Account account, @PathVariable("customerId") Long customerId) {
        return accountService.createAccount(account, customerId);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = PUT)
    public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathVariable("accountId") Long accountId) {
        return accountService.updateAccount(account, accountId);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = DELETE)
    public ResponseEntity deleteAccountById(@PathVariable("accountId") Long accountId) {
        return accountService.deleteAccountById(accountId);
    }
}
