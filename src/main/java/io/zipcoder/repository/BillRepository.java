package io.zipcoder.repository;

import io.zipcoder.domain.Bill;
import org.springframework.data.repository.CrudRepository;

/**
 * project: zcwbank
 * package: io.zipcoder.repository
 * author: https://github.com/vvmk
 * date: 4/9/18
 */

public interface BillRepository extends CrudRepository<Bill, Long> {
    Iterable<Bill> findAllByAccount_Id(Long accountId);

    Iterable<Bill> findAllByAccountCustomer_Id(Long customerId);
}
