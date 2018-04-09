package io.zipcoder.controller;

import io.zipcoder.domain.Bill;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: zcwbank
 * package: io.zipcoder.controller
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
@RestController
public class BillController {

    public ResponseEntity<Iterable<Bill>> getBillsByAccountId(Long accountId) {
        return null;
    }

    public ResponseEntity<Bill> getBillById(Long id) {
        return null;
    }

    public ResponseEntity<Iterable<Bill>> getBillsByCustomerId(Long customerId) {
        return null;
    }

    public ResponseEntity<Bill> createBill(Bill bill) {
        return null;
    }

    public ResponseEntity<Bill> updateBill(Bill bill) {
        return null;
    }

    public ResponseEntity deleteBillById(Long id) {
        return null;
    }
}
