package io.zipcoder.service.interfaces;

import io.zipcoder.domain.Account;
import org.springframework.http.ResponseEntity;

/**
 * project: zcwbank
 * package: io.zipcoder.service
 * author: https://github.com/vvmk
 * date: 4/9/18
 */

public interface AccountService {
    ResponseEntity<Iterable<Account>> getAllAccounts();

    ResponseEntity<Account> getAccountById(Long accountId);

    ResponseEntity<Iterable<Account>> getAccountsByCustomerId(Long customerId);

    ResponseEntity<Account> createAccount(Account account, Long customerId);

    ResponseEntity<Account> updateAccount(Account account, Long accountId);

    ResponseEntity deleteAccountById(Long accountId);
}
