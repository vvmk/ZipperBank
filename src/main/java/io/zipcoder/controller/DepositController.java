package io.zipcoder.controller;

import io.zipcoder.domain.Deposit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: zcwbank
 * package: io.zipcoder.controller
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
@RestController
public class DepositController {

    public ResponseEntity<Iterable<Deposit>> getAllDepositsByAccountId(Long accountId) {
        return null;
    }

    public ResponseEntity<Deposit> getDepositById(Long id) {
        return null;
    }

    public ResponseEntity<Deposit> createDeposit(Deposit deposit) {
        return null;
    }

    public ResponseEntity<Deposit> updateDeposit(Deposit deposit) {
        return null;
    }

    public ResponseEntity deleteDepositById(Long id) {
        return null;
    }
}
