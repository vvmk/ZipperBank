package io.zipcoder.service.implementations;

import io.zipcoder.domain.Account;
import io.zipcoder.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
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

        mockAccount = new Account();
        mockAccount.setId(1L);
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
    }

    @Test
    public void createAccount() {
    }

    @Test
    public void updateAccount() {
    }

    @Test
    public void deleteAccountById() {
    }

    @Test
    public void getAllAccounts() {
    }
}