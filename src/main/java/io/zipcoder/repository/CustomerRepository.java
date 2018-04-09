package io.zipcoder.repository;

import io.zipcoder.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * project: zcwbank
 * package: io.zipcoder.repository
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
