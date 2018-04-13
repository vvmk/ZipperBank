package io.zipcoder.repository;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * project: zcwbank
 * package: io.zipcoder.repository
 * author: https://github.com/vvmk
 * date: 4/13/18
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepo;

    @Test
    public void whenFindAllByCustomer_Id() {
        // given
        Customer mockCustomer = new Customer();
        Long customerId = entityManager.persistAndGetId(mockCustomer, Long.class);

        Account account = new Account();
        account.setCustomer(mockCustomer);

        entityManager.persist(account);
        entityManager.flush();

        // when
        Iterable<Account> foundAccounts = accountRepo.findAllByCustomer_Id(customerId);

        // then
        assertThat(foundAccounts).contains(account);
    }
}