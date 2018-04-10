package io.zipcoder.service.interfaces;

import io.zipcoder.domain.Deposit;
import org.springframework.http.ResponseEntity;

/**
 * project: zcwbank
 * package: io.zipcoder.service.interfaces
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
interface DepositService {
    ResponseEntity<Iterable<Deposit>> getAllDepositsByAccountId(Long accountId);

    ResponseEntity<Deposit> getDepositById(Long depositId);

    ResponseEntity<Deposit> createDeposit(Deposit deposit, Long accountId);

    ResponseEntity<Deposit> updateDeposit(Deposit deposit, Long depositId);

    ResponseEntity deleteDepositById(Long depositId);
}
