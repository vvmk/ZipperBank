package io.zipcoder.repository;

import io.zipcoder.domain.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * project: zcwbank
 * package: io.zipcoder.repository
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
}
