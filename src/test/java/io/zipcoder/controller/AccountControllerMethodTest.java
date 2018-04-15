package io.zipcoder.controller;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.service.interfaces.AccountService;
import org.apache.coyote.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * project: zcwbank
 * package: io.zipcoder.controller
 * author: https://github.com/vvmk
 * date: 4/14/18
 */
@RunWith(SpringRunner.class)
public class AccountControllerMethodTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    private Account mockAccount;
    private Customer mockCustomer;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockCustomer = new Customer();
        mockCustomer.setId(1L);

        mockAccount = new Account();
        mockAccount.setId(1L);
        mockAccount.setCustomer(mockCustomer);
    }

    @Test
    public void getAllAccounts() {
        Iterable<Account> accounts = singletonList(mockAccount);
        ResponseEntity<Iterable<Account>> expected = new ResponseEntity<>(accounts, OK);
        given(accountService.getAllAccounts())
                .willReturn(expected);

        ResponseEntity<Iterable<Account>> actual = accountController.getAllAccounts();

        verify(accountService).getAllAccounts();
        assertEquals(expected, actual);
    }

    @Test
    public void getAccountById() {
        ResponseEntity<Account> expected = new ResponseEntity<>(mockAccount, OK);
        given(accountController.getAccountById(anyLong()))
                .willReturn(expected);

        ResponseEntity<Account> actual = accountController.getAccountById(mockAccount.getId());

        verify(accountService).getAccountById(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void getAccountsByCustomerId() {
        Iterable<Account> accounts = singletonList(mockAccount);
        ResponseEntity<Iterable<Account>> expected = new ResponseEntity<>(accounts, OK);
        given(accountService.getAccountsByCustomerId(anyLong()))
                .willReturn(expected);

        ResponseEntity<Iterable<Account>> actual = accountController.getAccountsByCustomerId(mockAccount.getCustomer().getId());

        verify(accountService).getAccountsByCustomerId(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void createAccount() {
        ResponseEntity<Account> expected = new ResponseEntity<>(mockAccount, CREATED);
        given(accountService.createAccount(any(Account.class), anyLong()))
                .willReturn(expected);

        ResponseEntity<Account> actual = accountController.createAccount(mockAccount, mockAccount.getCustomer().getId());

        verify(accountService).createAccount(any(Account.class), anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void updateAccount() {
        ResponseEntity<Account> expected = new ResponseEntity<>(mockAccount, OK);
        given(accountService.updateAccount(any(Account.class), anyLong()))
                .willReturn(expected);

        ResponseEntity<Account> actual = accountController.updateAccount(mockAccount, mockAccount.getId());

        verify(accountService).updateAccount(any(Account.class), anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void deleteAccountById() {
        ResponseEntity expected = new ResponseEntity(OK);
        given(accountService.deleteAccountById(anyLong()))
                .willReturn(expected);
        
        ResponseEntity actual = accountController.deleteAccountById(mockAccount.getId());

        verify(accountService).deleteAccountById(anyLong());
        assertEquals(expected, actual);
    }
}