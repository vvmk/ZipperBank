package io.zipcoder.service;

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
}
