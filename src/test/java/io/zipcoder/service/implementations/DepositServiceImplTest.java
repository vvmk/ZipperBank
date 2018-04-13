package io.zipcoder.service.implementations;


import io.zipcoder.controller.DepositController;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import io.zipcoder.domain.Customer;

import io.zipcoder.domain.Deposit;
import io.zipcoder.repository.AccountRepository;

import io.zipcoder.repository.DepositRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.anyLong;

import static org.mockito.BDDMockito.given;

/**
 * project: zcwbank
 * package: io.zipcoder.service.implementations
 * author: https://github.com/vvmk
 * date: 4/9/18
 */

@RunWith(SpringRunner.class)
@WebMvcTest(DepositServiceImpl.class)//disables full auto config for having configs just for MVC components
public class DepositServiceImplTest {

    @InjectMocks// injects the made mocks into the deposit service
    private DepositServiceImpl depositService;

    @Mock // mock to be injected into depositService
    private DepositRepository depositRepository;

    @Mock
    private AccountRepository accountRepository;

    private Account mockAccount;
    private Deposit mockDeposit;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); //initializes fields annotated with Mockito annotations
        Customer mockCustomer = new Customer();
        mockCustomer.setId(369L);

        mockAccount = new Account();
        mockAccount.setId(369L);
        mockAccount.setCustomer(mockCustomer);

        mockDeposit = new Deposit();
        mockDeposit.setId(369L);
        mockDeposit.setPayee_id(mockAccount.getId());
    }

    @Test
    public void getAllDepositsByAccountIdTest() {

//        given(depositService.getAllDepositsByAccountId(mockAccount.getId()))
//                .willReturn();

        Iterable<Deposit> deposits = singletonList(mockDeposit);
        given(depositService.getAllDepositsByAccountId(anyLong()))
                .willReturn(new ResponseEntity<>(deposits, HttpStatus.OK));


    }


}