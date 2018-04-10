package io.zipcoder.service.implementations;

import io.zipcoder.repository.DepositRepository;
import io.zipcoder.service.interfaces.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
