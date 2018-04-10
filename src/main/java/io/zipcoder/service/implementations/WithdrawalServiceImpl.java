package io.zipcoder.service.implementations;

import io.zipcoder.repository.WithdrawalRepository;
import io.zipcoder.service.interfaces.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
