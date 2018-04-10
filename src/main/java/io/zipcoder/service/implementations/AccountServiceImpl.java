package io.zipcoder.service.implementations;

import io.zipcoder.domain.Account;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * project: zcwbank
 * package: io.zipcoder.service
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    public ResponseEntity<Account> getAccountById(Long accountId) {
        return null;
    }

    public ResponseEntity<Iterable<Account>> getAccountsByCustomerId(Long customerId) {
        return null;
    }

    public ResponseEntity<Account> createAccount(Account account, Long customerId) {
        return null;
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
