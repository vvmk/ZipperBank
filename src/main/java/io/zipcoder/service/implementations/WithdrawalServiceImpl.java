package io.zipcoder.service.implementations;

import io.zipcoder.domain.Withdrawal;
import io.zipcoder.repository.WithdrawalRepository;
import io.zipcoder.service.interfaces.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * project: zcwbank
 * package: io.zipcoder.service.implementations
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
@Service
public class WithdrawalServiceImpl implements WithdrawalService {

    private WithdrawalRepository withdrawalRepo;

    @Autowired
    public WithdrawalServiceImpl(WithdrawalRepository withdrawalRepo) {
        this.withdrawalRepo = withdrawalRepo;
    }

    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawalsByAccountId(Long accountId) {
        return null;
    }

    public ResponseEntity<Withdrawal> getWithdrawalById(Long withdrawalId) {
        return null;
    }

    public ResponseEntity<Withdrawal> createWithdrawal(Withdrawal withdrawal, Long accountId) {
        return null;
    }

    public ResponseEntity<Withdrawal> updateWithdrawal(Withdrawal withdrawal, Long withdrawalId) {
        return null;
    }

    public ResponseEntity deleteWithdrawalById(Long withdrawalId) {
        return null;
    }
}
