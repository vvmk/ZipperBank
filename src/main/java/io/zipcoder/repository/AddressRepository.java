package io.zipcoder.repository;

import io.zipcoder.domain.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * project: zcwbank
 * package: io.zipcoder.repository
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
    Address findByCustomer_Id(Long customerId);
}
