package io.zipcoder.controller;

import io.zipcoder.domain.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: zcwbank
 * package: io.zipcoder.controller
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
@RestController
public class AccountController {

    public ResponseEntity<Iterable<Account>> getAllAccounts() {
        return null;
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
