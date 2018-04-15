package io.zipcoder.service.implementations;

import io.zipcoder.domain.Withdrawal;
import io.zipcoder.repository.WithdrawalRepository;
import io.zipcoder.service.interfaces.WithdrawalService;
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
public class WithdrawalServiceImpl implements WithdrawalService {

    private WithdrawalRepository withdrawalRepo;

    @Autowired
    public WithdrawalServiceImpl(WithdrawalRepository withdrawalRepo) {
        this.withdrawalRepo = withdrawalRepo;
    }

    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawalsByAccountId(Long accountId) {
        Iterable<Withdrawal> allWithdrawals = withdrawalRepo.findAllByAccount_Id(accountId);
        return new ResponseEntity<>(allWithdrawals, HttpStatus.OK);
    }

    public ResponseEntity<Withdrawal> getWithdrawalById(Long withdrawalId) {
        Withdrawal singleWithdrawal = withdrawalRepo.getById(withdrawalId);
        return new ResponseEntity<>(singleWithdrawal, HttpStatus.OK);
    }

    public ResponseEntity<Withdrawal> createWithdrawal(Withdrawal withdrawal, Long accountId) {
        withdrawal = withdrawalRepo.save(withdrawal);
//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI newPollUri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/accounts/{id}/withdrawal")
//                .buildAndExpand(withdrawal.getId())
//                .toUri();
//        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(withdrawal, HttpStatus.CREATED);
    }

    public ResponseEntity<Withdrawal> updateWithdrawal(Withdrawal withdrawal, Long withdrawalId) {
        Withdrawal w = withdrawalRepo.save(withdrawal);
        return new ResponseEntity<>(w, HttpStatus.OK);
    }

    public ResponseEntity deleteWithdrawalById(Long withdrawalId) {
        withdrawalRepo.deleteById(withdrawalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

