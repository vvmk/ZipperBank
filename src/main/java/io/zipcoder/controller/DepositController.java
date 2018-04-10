package io.zipcoder.controller;

import io.zipcoder.domain.Deposit;
import io.zipcoder.service.interfaces.DepositService;
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
public class DepositController {

    private DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = GET)
    public ResponseEntity<Iterable<Deposit>> getAllDepositsByAccountId(@PathVariable Long accountId) {
        return depositService.getAllDepositsByAccountId(accountId);
    }

    @RequestMapping(value = "/deposits/{depositId}", method = GET)
    public ResponseEntity<Deposit> getDepositById(@PathVariable Long depositId) {
        return depositService.getDepositById(depositId);
    }

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = POST)
    public ResponseEntity<Deposit> createDeposit(@RequestBody Deposit deposit, @PathVariable Long accountId) {
        return depositService.createDeposit(deposit, accountId);
    }

    @RequestMapping(value = "/deposits/{depositId}", method = PUT)
    public ResponseEntity<Deposit> updateDeposit(@RequestBody Deposit deposit, @PathVariable Long depositId) {
        return depositService.updateDeposit(deposit, depositId);
    }

    @RequestMapping(value = "/deposits/{depositId}", method = DELETE)
    public ResponseEntity deleteDepositById(@PathVariable Long depositId) {
        return depositService.deleteDepositById(depositId);
    }
}
