package io.zipcoder.service.implementations;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.OK;

/**
 * project: zcwbank
 * package: io.zipcoder.service.implementations
 * author: https://github.com/vvmk
 * date: 4/13/18
 */
public class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepo;

    private Account mockAccount;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Customer mockCustomer = new Customer();
        mockCustomer.setId(1L);

        mockAccount = new Account();
        mockAccount.setId(1L);
        mockAccount.setCustomer(mockCustomer);
    }

    @Test
    public void getAccountById() {
        given(accountRepo.findById(anyLong()))
                .willReturn(Optional.of(mockAccount));

        ResponseEntity<Account> expected = new ResponseEntity<>(mockAccount, OK);
        ResponseEntity<Account> actual = accountService.getAccountById(mockAccount.getId());

        verify(accountRepo).findById(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void getAccountsByCustomerId() {
        Iterable<Account> accounts = singletonList(mockAccount);
        given(accountRepo.findAllByCustomer_Id(anyLong()))
                .willReturn(accounts);

        ResponseEntity<Iterable<Account>> expected = new ResponseEntity<>(accounts, OK);
        ResponseEntity<Iterable<Account>> actual = accountService.getAccountsByCustomerId(mockAccount.getCustomer().getId());

        verify(accountRepo).findAllByCustomer_Id(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void createAccount() {
        fail();
    }

    @Test
    public void updateAccount() {
        fail();
    }

    @Test
    public void deleteAccountById() {
        fail();
    }

    @Test
    public void getAllAccounts() {
        fail();
    }
}