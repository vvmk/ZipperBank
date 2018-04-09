package io.zipcoder.controller;

import io.zipcoder.domain.Withdrawal;
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
public class WithdrawalController {

    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = GET)
    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawalsByAccountId(@PathVariable Long accountId) {
        return null;
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = GET)
    public ResponseEntity<Withdrawal> getWithdrawalById(@PathVariable Long withdrawalId) {
        return null;
    }

    @RequestMapping(value = "/accounts/{accountId}/withdrawal", method = POST)
    public ResponseEntity<Withdrawal> createWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long accountId) {
        return null;
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = PUT)
    public ResponseEntity<Withdrawal> updateWithdrawal(Withdrawal withdrawal) {
        return null;
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = DELETE)
    public ResponseEntity deleteWithdrawalById(@PathVariable Long withdrawalId) {
        return null;
    }
}
