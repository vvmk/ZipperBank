package io.zipcoder.controller;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.domain.Withdrawal;
import io.zipcoder.service.interfaces.WithdrawalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

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
public class WithdrawalControllerTest {

    @Mock
    private WithdrawalService withdrawalService;

    @InjectMocks
    private WithdrawalController withdrawalController;

    private Account mockAccount;
    private Withdrawal mockWithdrawal;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Customer mockCustomer = new Customer();
        mockCustomer.setId(1L);

        mockAccount = new Account();
        mockAccount.setId(1L);
        mockAccount.setCustomer(mockCustomer);

        mockWithdrawal = new Withdrawal();
        mockWithdrawal.setId(1L);
        mockWithdrawal.setAccount(mockAccount);
    }

    @Test
    public void getAllWithdrawalsByAccountIdTest() {
        Iterable<Withdrawal> withdrawals = singletonList(mockWithdrawal);
        ResponseEntity<Iterable<Withdrawal>> expected = new ResponseEntity<>(withdrawals, HttpStatus.OK);
        given(withdrawalService.getAllWithdrawalsByAccountId(anyLong()))
                .willReturn(expected);

        ResponseEntity<Iterable<Withdrawal>> actual = withdrawalController.getAllWithdrawalsByAccountId(mockAccount.getId());

        verify(withdrawalService).getAllWithdrawalsByAccountId(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void getWithdrawalByIdTest() {
        ResponseEntity<Withdrawal> expected = new ResponseEntity<>(mockWithdrawal, HttpStatus.OK);
        given(withdrawalService.getWithdrawalById(369L))
                .willReturn(expected);

        ResponseEntity<Withdrawal> actual = withdrawalController.getWithdrawalById(369L);

        verify(withdrawalService).getWithdrawalById(369L);
        assertEquals(expected, actual);
    }

    @Test
    public void createWithdrawalTest() {
        ResponseEntity<Withdrawal> expected = new ResponseEntity<>(mockWithdrawal, HttpStatus.CREATED);
        given(withdrawalService.createWithdrawal(any(Withdrawal.class), anyLong()))
                .willReturn(expected);

        ResponseEntity<Withdrawal> actual = withdrawalController.createWithdrawal(mockWithdrawal, mockAccount.getId());

        verify(withdrawalService).createWithdrawal(any(Withdrawal.class), anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void updateWithdrawalTest() {
        ResponseEntity<Withdrawal> expected = new ResponseEntity<>(mockWithdrawal, HttpStatus.OK);
        given(withdrawalService.updateWithdrawal(any(Withdrawal.class), anyLong()))
                .willReturn(expected);

        ResponseEntity<Withdrawal> actual = withdrawalController.updateWithdrawal(mockWithdrawal, mockWithdrawal.getId());

        verify(withdrawalService).updateWithdrawal(any(Withdrawal.class), anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void deleteWithdrawalById() {
        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        given(withdrawalService.deleteWithdrawalById(anyLong()))
                .willReturn(expected);

        ResponseEntity actual = withdrawalController.deleteWithdrawalById(mockWithdrawal.getId());

        verify(withdrawalService).deleteWithdrawalById(anyLong());
        assertEquals(expected, actual);
    }

}