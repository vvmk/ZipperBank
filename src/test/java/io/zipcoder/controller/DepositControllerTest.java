package io.zipcoder.controller;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.domain.Deposit;
import io.zipcoder.service.interfaces.DepositService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * project: zcwbank
 * package: io.zipcoder.controller
 * author: https://github.com/vvmk
 * date: 4/14/18
 */

@RunWith(SpringRunner.class)
public class DepositControllerTest {

    @Mock
    private DepositService depositService;

    @InjectMocks
    private DepositController depositController;

    private Account mockAccount;
    private Deposit mockDeposit;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Customer mockCustomer = new Customer();
        mockCustomer.setId(1L);

        mockAccount = new Account();
        mockAccount.setId(1L);
        mockAccount.setCustomer(mockCustomer);

        mockDeposit = new Deposit();
        mockDeposit.setId(1L);
        mockDeposit.setAccount(mockAccount);
    }

    @Test
    public void getAllDepositsByAccountIdTest() {
        Iterable<Deposit> deposits = singletonList(mockDeposit);
        ResponseEntity<Iterable<Deposit>> expected = new ResponseEntity<>(deposits, HttpStatus.OK);
        given(depositService.getAllDepositsByAccountId(anyLong()))
                .willReturn(expected);

        ResponseEntity<Iterable<Deposit>> actual = depositController.getAllDepositsByAccountId(mockAccount.getId());

        verify(depositService).getAllDepositsByAccountId(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void getDepositByIdTest() {
        ResponseEntity<Deposit> expected = new ResponseEntity<>(mockDeposit, HttpStatus.OK);
        given(depositService.getDepositById(369L))
                .willReturn(expected);

        ResponseEntity<Deposit> actual = depositController.getDepositById(369L);

        verify(depositService).getDepositById(369L);
        assertEquals(expected, actual);
    }

    @Test
    public void createDepositTest() {
        ResponseEntity<Deposit> expected = new ResponseEntity<>(mockDeposit, HttpStatus.CREATED);
        given(depositService.createDeposit(any(Deposit.class), anyLong()))
                .willReturn(expected);

        ResponseEntity<Deposit> actual = depositController.createDeposit(mockDeposit, mockAccount.getId());

        verify(depositService).createDeposit(any(Deposit.class), anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void updateDepositTest() {
        ResponseEntity<Deposit> expected = new ResponseEntity<>(mockDeposit, HttpStatus.OK);
        given(depositService.updateDeposit(any(Deposit.class), anyLong()))
                .willReturn(expected);

        ResponseEntity<Deposit> actual = depositController.updateDeposit(mockDeposit, mockDeposit.getId());

        verify(depositService).updateDeposit(any(Deposit.class), anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void deleteDepositById() {
        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        given(depositService.deleteDepositById(anyLong()))
                .willReturn(expected);

        ResponseEntity actual = depositController.deleteDepositById(mockDeposit.getId());

        verify(depositService).deleteDepositById(anyLong());
        assertEquals(expected, actual);
    }

}