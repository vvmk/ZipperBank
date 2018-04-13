package io.zipcoder.service.implementations;

import io.zipcoder.domain.Deposit;
import io.zipcoder.repository.DepositRepository;
import io.zipcoder.service.interfaces.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
        //access the deposit repository
        Iterable<Deposit> allDeposits = depositRepo.getDepositsByAccount_Id(accountId);
        //return all deposits from that have that account id;
        return new ResponseEntity<>(allDeposits, HttpStatus.OK);
    }

    public ResponseEntity<Deposit> getDepositById(Long depositId) {
        Deposit deposit = depositRepo.getDepositById(depositId);
        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }

    public ResponseEntity<Deposit> createDeposit(Deposit deposit, Long accountId) {
        depositRepo.save(deposit);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{accountId}").buildAndExpand(accountId).toUri());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<Deposit> updateDeposit(Deposit deposit, Long depositId) {
        depositRepo.save(deposit);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{depositId}").buildAndExpand(depositId).toUri());
        return null;
    }

    public ResponseEntity deleteDepositById(Long depositId) {
        depositRepo.deleteById(depositId);
        return new ResponseEntity(HttpStatus.valueOf(204));
    }
}
