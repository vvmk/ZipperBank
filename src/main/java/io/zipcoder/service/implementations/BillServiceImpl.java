package io.zipcoder.service.implementations;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.BillRepository;
import io.zipcoder.service.interfaces.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

/**
 * project: zcwbank
 * package: io.zipcoder.service.implementations
 * author: https://github.com/vvmk
 * date: 4/9/18
 */

@Service
public class BillServiceImpl implements BillService {

    private BillRepository billRepo;
    private AccountRepository accountRepo;

    @Autowired
    public BillServiceImpl(BillRepository billRepo, AccountRepository accountRepo) {
        this.billRepo = billRepo;
        this.accountRepo = accountRepo;
    }

    public ResponseEntity<Iterable<Bill>> getBillsByAccountId(Long accountId) {
        Iterable<Bill> bills = billRepo.findAllByAccount_Id(accountId);
        return new ResponseEntity<>(bills, OK);
    }

    public ResponseEntity<Bill> getBillById(Long id) {
        Optional<Bill> billOrNah = billRepo.findById(id);
        Bill bill = billOrNah.orElse(new Bill());
        HttpStatus status = billOrNah.isPresent() ? OK : NOT_FOUND;
        return new ResponseEntity<>(bill, status);
    }

    public ResponseEntity<Iterable<Bill>> getBillsByCustomerId(Long customerId) {
        Iterable<Bill> bills = billRepo.findAllByAccountCustomer_Id(customerId);
        return new ResponseEntity<>(bills, OK);
    }

    public ResponseEntity<Bill> createBill(Bill bill, Long accountId) {
        try {
            Account account = accountRepo.findById(accountId).orElseThrow(Exception::new);
            bill.setAccount(account);
            Bill returnedBill = billRepo.save(bill);
            return new ResponseEntity<>(returnedBill, CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new Bill(), BAD_REQUEST);
        }
    }

    public ResponseEntity<Bill> updateBill(Bill bill, Long billId) {
        return null;
    }

    public ResponseEntity deleteBillById(Long billId) {
        billRepo.deleteById(billId);
        return new ResponseEntity(OK);
    }
}
