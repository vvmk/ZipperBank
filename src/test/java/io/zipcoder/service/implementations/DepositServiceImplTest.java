package io.zipcoder.service.implementations;


import io.zipcoder.controller.DepositController;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.DepositRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

/**
 * project: zcwbank
 * package: io.zipcoder.service.implementations
 * author: https://github.com/vvmk
 * date: 4/9/18
 */

@RunWith(SpringRunner.class)
@WebMvcTest(DepositServiceImpl.class)
public class DepositServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepositServiceImpl depositService;

    private Account mockAccount;
    private Bill mockBill;

    @Before
    public void setUp() {
        Customer mockCustomer = new Customer();
        mockCustomer.setId(369L);

        mockAccount = new Account();
        mockAccount.setId(369L);
        mockAccount.setCustomer(mockCustomer);

        mockBill = new Bill();
        mockBill.setId(369L);
        mockBill.setAccount(mockAccount);
        mockBill.setStatus("Processing Payment");
    }

    @Test
    public void getAllDepositsByAccountIdTest(){
        given(depositService.getAllDepositsByAccountId(mockAccount.getId()))
                .willReturn();
    }

}