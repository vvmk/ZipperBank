package io.zipcoder.controller;

import io.zipcoder.domain.Account;
import io.zipcoder.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

    @RequestMapping(value="/accounts",method = GET)
    public ResponseEntity<Iterable<Account>> getAllAccounts() {
        return acctService.getAllAccounts();
    }

    public ResponseEntity<Account> getAccountById(Long id) {
        return null;
    }

    public ResponseEntity<Iterable<Account>> getAccountsByCustomerId(Long id) {
        return null;
    }

    public ResponseEntity<Account> createAccount(Account account) {
        return null;
    }

    public ResponseEntity<Account> updateAccount(Account account) {
        return null;
    }

    public ResponseEntity deleteAccountById(Long id) {
        return null;
    }
}
