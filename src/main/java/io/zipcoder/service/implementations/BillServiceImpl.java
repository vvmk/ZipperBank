package io.zipcoder.service.implementations;

import io.zipcoder.repository.BillRepository;
import io.zipcoder.service.interfaces.BillService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
