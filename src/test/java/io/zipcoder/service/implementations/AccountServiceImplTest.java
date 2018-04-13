package io.zipcoder.service.implementations;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * project: zcwbank
 * package: io.zipcoder.service.implementations
 * author: https://github.com/vvmk
 * date: 4/13/18
 */

@RunWith(SpringRunner.class)
public class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepo;

    @Mock
    private CustomerRepository customerRepo;

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
        given(customerRepo.findById(anyLong()))
                .willReturn(Optional.of(mockAccount.getCustomer()));
        given(accountRepo.save(any(Account.class)))
                .willReturn(mockAccount);

        ResponseEntity<Account> expected = new ResponseEntity<>(mockAccount, CREATED);
        ResponseEntity<Account> actual = accountService.createAccount(mockAccount, mockAccount.getCustomer().getId());

        verify(accountRepo).save(any(Account.class));
        assertEquals(expected, actual);
    }

    @Test
    public void updateAccount() {
        given(accountRepo.save(any(Account.class)))
                .willReturn(mockAccount);

        ResponseEntity<Account> expected = new ResponseEntity<>(mockAccount, OK);
        ResponseEntity<Account> actual = accountService.updateAccount(mockAccount, mockAccount.getId());

        verify(accountRepo).save(any(Account.class));
        assertEquals(expected, actual);
    }

    @Test
    public void deleteAccountById() {
        ResponseEntity expected = new ResponseEntity(OK);
        ResponseEntity actual = accountService.deleteAccountById(mockAccount.getId());

        verify(accountRepo).deleteById(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void getAllAccounts() {
        Iterable<Account> accounts = singletonList(mockAccount);
        given(accountRepo.findAll())
                .willReturn(accounts);

        ResponseEntity expected = new ResponseEntity(accounts, OK);
        ResponseEntity actual = accountService.getAllAccounts();

        verify(accountRepo).findAll();
        assertEquals(expected, actual);
    }
}