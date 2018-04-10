package io.zipcoder.service.interfaces;

import io.zipcoder.domain.Withdrawal;
import org.springframework.http.ResponseEntity;

/**
 * project: zcwbank
 * package: io.zipcoder.service.interfaces
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
public interface WithdrawalService {
    ResponseEntity<Iterable<Withdrawal>> getAllWithdrawalsByAccountId(Long accountId);

    ResponseEntity<Withdrawal> getWithdrawalById(Long withdrawalId);

    ResponseEntity<Withdrawal> createWithdrawal(Withdrawal withdrawal, Long accountId);

    ResponseEntity<Withdrawal> updateWithdrawal(Withdrawal withdrawal);

    ResponseEntity deleteWithdrawalById(Long withdrawalId);
}
