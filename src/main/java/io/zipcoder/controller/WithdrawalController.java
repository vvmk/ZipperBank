package io.zipcoder.controller;

import io.zipcoder.domain.Withdrawal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: zcwbank
 * package: io.zipcoder.controller
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
@RestController
public class WithdrawalController {

    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawalsByAccountId(Long accountId) {
        return null;
    }

    public ResponseEntity<Withdrawal> getWithdrawalById(Long id) {
        return null;
    }

    public ResponseEntity<Withdrawal> createWithdrawal(Withdrawal withdrawal) {
        return null;
    }

    public ResponseEntity<Withdrawal> updateWithdrawal(Withdrawal withdrawal) {
        return null;
    }

    public ResponseEntity deleteWithdrawalById(Long id) {
        return null;
    }
}
