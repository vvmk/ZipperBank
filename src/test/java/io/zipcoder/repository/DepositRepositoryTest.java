package io.zipcoder.repository;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Deposit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
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
public class DepositRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DepositRepository depositRepo;

    @Test
    public void getDepositsByAccount_Id() {
        Account testAccount = new Account();
        Long accountId = entityManager.persistAndGetId(testAccount, Long.class);

        Deposit testDeposit = new Deposit();
        testDeposit.setAccount(testAccount);
        entityManager.persistAndFlush(testDeposit);

        Iterable<Deposit> foundDeposits = depositRepo.getDepositsByAccount_Id(accountId);

        assertThat(foundDeposits).contains(testDeposit);
    }

    @Test
    public void getDepositById() {
        Deposit expected = new Deposit();
        Long depositId = entityManager.persistAndGetId(expected, Long.class);

        Deposit actual = depositRepo.getDepositById(depositId);

        assertEquals(expected, actual);
    }
}