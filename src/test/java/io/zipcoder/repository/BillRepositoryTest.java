package io.zipcoder.repository;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import io.zipcoder.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

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
public class BillRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BillRepository billRepository;

    @Test
    public void findAllByAccount_Id() {
        //given
        Account testAccount = new Account();
        Long accountId = entityManager.persistAndGetId(testAccount, Long.class);

        Bill bill = new Bill();
        bill.setAccount(testAccount);

        entityManager.persist(bill);
        entityManager.flush();

        //when
        Iterable<Bill> foundBill = billRepository.findAllByAccount_Id(accountId);

        //then
        assertThat(foundBill).contains(bill);
    }

    @Test
    public void findAllByAccount_Customer_Id() {
        //given
        Customer testCustomer = new Customer();
        Long customerId = entityManager.persistAndGetId(testCustomer, Long.class);

        Account testAccount = new Account();
        testAccount.setCustomer(testCustomer);
        entityManager.persist(testAccount);

        Bill testBill = new Bill();
        testBill.setAccount(testAccount);
        entityManager.persistAndFlush(testBill);

        //when
        Iterable<Bill> foundBills = billRepository.findAllByAccount_Customer_Id(customerId);

        //then
        assertThat(foundBills).contains(testBill);
    }
}