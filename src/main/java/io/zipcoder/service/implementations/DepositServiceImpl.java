package io.zipcoder.service.implementations;

import io.zipcoder.domain.Deposit;
import io.zipcoder.repository.DepositRepository;
import io.zipcoder.service.interfaces.DepositService;
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
public class DepositServiceImpl implements DepositService {

    private DepositRepository depositRepo;

    @Autowired
    public DepositServiceImpl(DepositRepository depositRepo) {
        this.depositRepo = depositRepo;
    }

    public ResponseEntity<Iterable<Deposit>> getAllDepositsByAccountId(Long accountId) {
        return null;
    }

    public ResponseEntity<Deposit> getDepositById(Long depositId) {
        return null;
    }

    public ResponseEntity<Deposit> createDeposit(Deposit deposit, Long accountId) {
        return null;
    }

    public ResponseEntity<Deposit> updateDeposit(Deposit deposit, Long depositId) {
        return null;
    }

    public ResponseEntity deleteDepositById(Long depositId) {
        return null;
    }
}
