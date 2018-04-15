package io.zipcoder.repository;

import io.zipcoder.domain.Address;
import io.zipcoder.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * project: zcwbank
 * package: io.zipcoder.repository
 * author: https://github.com/vvmk
 * date: 4/14/18
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class AddressRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testAddress() {

        Address address = new Address();
        address.setCity("San Fransisco");
        address.setState("California");
        address.setStreet_name("Fake St");
        address.setStreet_number("123");

        Customer customer = new Customer();
        Long customerId = entityManager.persistAndGetId(customer, Long.class);
        customer.setAddress(address);

        address.setCustomer(customer);
        entityManager.persistAndFlush(address);

        Address foundAddress = addressRepository.findByCustomer_Id(customerId);

        assertEquals(address, foundAddress);
    }
}