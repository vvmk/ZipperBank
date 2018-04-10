package io.zipcoder.service.interfaces;

import io.zipcoder.domain.Bill;
import org.springframework.http.ResponseEntity;

/**
 * project: zcwbank
 * package: io.zipcoder.service.interfaces
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
interface BillService {
    ResponseEntity<Iterable<Bill>> getBillsByAccountId(Long accountId);

    ResponseEntity<Bill> getBillById(Long id);

    ResponseEntity<Iterable<Bill>> getBillsByCustomerId(Long customerId);

    ResponseEntity<Bill> createBill(Bill bill, Long accountId);

    ResponseEntity<Bill> updateBill(Bill bill, Long billId);

    ResponseEntity deleteBillById(Long billId);
}
