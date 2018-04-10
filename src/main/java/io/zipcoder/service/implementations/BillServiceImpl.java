package io.zipcoder.service.implementations;

import io.zipcoder.domain.Bill;
import io.zipcoder.repository.BillRepository;
import io.zipcoder.service.interfaces.BillService;
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
public class BillServiceImpl implements BillService {

    private BillRepository billRepo;

    @Autowired
    public BillServiceImpl(BillRepository billRepo) {
        this.billRepo = billRepo;
    }

    public ResponseEntity<Iterable<Bill>> getBillsByAccountId(Long accountId) {
        return null;
    }

    public ResponseEntity<Bill> getBillById(Long id) {
        return null;
    }

    public ResponseEntity<Iterable<Bill>> getBillsByCustomerId(Long customerId) {
        return null;
    }

    public ResponseEntity<Bill> createBill(Bill bill, Long accountId) {
        return null;
    }

    public ResponseEntity<Bill> updateBill(Bill bill, Long billId) {
        return null;
    }

    public ResponseEntity deleteBillById(Long billId) {
        return null;
    }
}
