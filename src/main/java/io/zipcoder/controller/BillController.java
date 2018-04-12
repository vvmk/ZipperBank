package io.zipcoder.controller;

import io.zipcoder.domain.Bill;
import io.zipcoder.service.interfaces.BillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * project: zcwbank
 * package: io.zipcoder.controller
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
@RestController
public class BillController {

    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping(value = "/accounts/{accountId}/bills", method = GET)
    public ResponseEntity<Iterable<Bill>> getBillsByAccountId(@PathVariable("accountId") Long accountId) {
        return billService.getBillsByAccountId(accountId);
    }

    @RequestMapping(value = "/bills/{billId}", method = GET)
    public ResponseEntity<Bill> getBillById(@PathVariable Long billId) {
        return billService.getBillById(billId);
    }

    @RequestMapping(value = "/customers/{customerId}/bills", method = GET)
    public ResponseEntity<Iterable<Bill>> getBillsByCustomerId(@PathVariable Long customerId) {
        return billService.getBillsByCustomerId(customerId);
    }

    @RequestMapping(value = "/accounts/{accountId}/bills", method = POST)
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill, @PathVariable Long accountId) {
        return billService.createBill(bill, accountId);
    }

    @RequestMapping(value = "/bills/{billId}", method = PUT)
    public ResponseEntity<Bill> updateBill(@RequestBody Bill bill, @PathVariable Long billId) {
        return billService.updateBill(bill, billId);
    }

    @RequestMapping(value = "/bills/{billId}", method = DELETE)
    public ResponseEntity deleteBillById(@PathVariable Long billId) {
        return billService.deleteBillById(billId);
    }
}
