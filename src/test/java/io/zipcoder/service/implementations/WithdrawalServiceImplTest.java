package io.zipcoder.service.implementations;

<<<<<<< HEAD
=======
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Withdrawal;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.WithdrawalRepository;
import io.zipcoder.service.interfaces.WithdrawalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

>>>>>>> stash and rebase
/**
 * project: zcwbank
 * package: io.zipcoder.service.implementations
 * author: https://github.com/vvmk
 * date: 4/9/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WithdrawalServiceImplTest {

    @InjectMocks
    WithdrawalServiceImpl withdrawalServiceImpl;

    @Mock
    WithdrawalRepository withdrawalRepoMock;

    @Mock
    AccountRepository accountRepoMock;

    private Account mockAccount;
    private Withdrawal mockWithdrawal;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockAccount = new Account();
        mockAccount.setId(1234L);

        mockWithdrawal = new Withdrawal();
        mockWithdrawal.setAmount(500.00);
        mockWithdrawal.setId(666L);
        mockWithdrawal.setAccount_id(1234L);


    }

    @Test
    public void testGetAllWithdrawalByAccountId(){
        withdrawalServiceImpl.getAllWithdrawalsByAccountId(1L);
        verify(withdrawalRepoMock).getAllByAmount(1L);

        assertEquals(13.00, withdrawalServiceImpl.getAllWithdrawalsByAccountId(1234l));
    }


    @Test
    public void testGetWithdrawalById(){

    }

    @Test
    public void testCreateWithdrawal(){

    }

    @Test
    public void testUpdateWithdrawal(){

    }

    @Test
    public void testDeleteWithdrawal(){

    }


}