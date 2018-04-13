package io.zipcoder.service.implementations;

import io.zipcoder.domain.Deposit;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.DepositRepository;
import io.zipcoder.service.interfaces.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    private AccountRepository accountRepo;
    private DepositRepository depositRepo;

    @Autowired
    public DepositServiceImpl(DepositRepository depositRepo, AccountRepository accountRepo) {
        this.depositRepo = depositRepo;
        this.accountRepo = accountRepo;
    }

    public ResponseEntity<Iterable<Deposit>> getAllDepositsByAccountId(Long accountId) {

        Iterable<Deposit> allDeposits = depositRepo.getDepositsByAccount_Id(accountId);
        //TODO: Check if account exists
        return new ResponseEntity<>(allDeposits, HttpStatus.OK);
    }

    public ResponseEntity<Deposit> getDepositById(Long depositId) {
        //TODO: Check if deposit id exists
        Deposit deposit = depositRepo.getDepositById(depositId);
        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }

    public ResponseEntity<Deposit> createDeposit(Deposit deposit, Long accountId) {
        //TODO: Check if account exists
        deposit.setPayee_id(accountId);
        depositRepo.save(deposit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<Deposit> updateDeposit(Deposit deposit, Long depositId) {
        //TODO: check if deposit exists by that id
        Deposit updateDeposit = depositRepo.getDepositById(depositId);
        deposit = depositRepo.save(updateDeposit);
        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }

    public ResponseEntity deleteDepositById(Long depositId) {
        depositRepo.deleteById(depositId);
        return new ResponseEntity(HttpStatus.valueOf(204));
    }
}
