package io.zipcoder.repository;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Deposit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * project: zcwbank
 * package: io.zipcoder.repository
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
public interface DepositRepository extends CrudRepository<Deposit, Long> {


    Iterable<Deposit> getDepositsByAccount_Id(Long accountId);

    Deposit getDepositById(Long id);
}

