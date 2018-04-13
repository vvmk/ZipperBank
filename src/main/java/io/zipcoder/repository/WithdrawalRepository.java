package io.zipcoder.repository;

import io.zipcoder.domain.Withdrawal;
import org.springframework.data.repository.CrudRepository;

/**
 * project: zcwbank
 * package: io.zipcoder.repository
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long> {

     Iterable<Withdrawal> getAllByAmount(Long accountId);

     Iterable<Withdrawal> findAllByAccount_Id(Long accountId);

     Iterable<Withdrawal> findByAccount_Id(Long accountId);

     Withdrawal getById(Long withdrawalId);

}

