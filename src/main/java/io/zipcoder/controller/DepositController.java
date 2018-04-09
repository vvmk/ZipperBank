package io.zipcoder.controller;

import io.zipcoder.domain.Deposit;
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

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = GET)
    public ResponseEntity<Iterable<Deposit>> getAllDepositsByAccountId(@PathVariable Long accountId) {
        return null;
    }

    @RequestMapping(value = "/deposits/{depositId}", method = GET)
    public ResponseEntity<Deposit> getDepositById(@PathVariable Long depositId) {
        return null;
    }

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = POST)
    public ResponseEntity<Deposit> createDeposit(@RequestBody Deposit deposit, @PathVariable Long accountId) {
        return null;
    }

    @RequestMapping(value = "/deposits/{depositId}", method = PUT)
    public ResponseEntity<Deposit> updateDeposit(@RequestBody Deposit deposit, @PathVariable Long depositId) {
        return null;
    }

    @RequestMapping(value = "/deposits/{depositId}", method = DELETE)
    public ResponseEntity deleteDepositById(@PathVariable Long depositId) {
        return null;
    }
}
