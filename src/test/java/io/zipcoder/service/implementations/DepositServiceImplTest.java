package io.zipcoder.service.implementations;

import io.zipcoder.domain.Account;
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
 * package: io.zipcoder.service.implementations
 * author: https://github.com/vvmk
 * date: 4/9/18
 */


@RunWith(SpringRunner.class)
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
        mockDeposit.setAccount(mockAccount);
    }

    @Test
    public void getAllDepositsByAccountIdTest() {
        Iterable<Deposit> deposits = singletonList(mockDeposit);
        given(depositRepository.getDepositsByAccount_Id(anyLong()))
                .willReturn(deposits);
        ResponseEntity<Iterable<Deposit>> expected = new ResponseEntity<>(deposits, HttpStatus.OK);
        ResponseEntity<Iterable<Deposit>> actual = depositService.getAllDepositsByAccountId(mockAccount.getId());

        verify(depositRepository).getDepositsByAccount_Id(anyLong());
        assertEquals(expected, actual);

    }

    @Test
    public void getDepositByIdTest() {
        given(depositRepository.getDepositById(369L)).willReturn(mockDeposit);

        ResponseEntity<Deposit> expected = new ResponseEntity<>(mockDeposit, HttpStatus.OK);
        ResponseEntity<Deposit> actual = depositService.getDepositById(369L);

        verify(depositRepository).getDepositById(369L);
        assertEquals(expected, actual);
    }

    @Test
    public void createDepositTest() {
        given(accountRepository.findById(anyLong())).willReturn(Optional.of(mockAccount));
        given(depositRepository.save(any(Deposit.class))).willReturn(mockDeposit);// any allows flexible stubbing and verification

        ResponseEntity<Deposit> expected = new ResponseEntity<>(mockDeposit, HttpStatus.CREATED);
        ResponseEntity<Deposit> actual = depositService.createDeposit(mockDeposit, mockAccount.getId());

        verify(depositRepository).save(any(Deposit.class));
        assertEquals(expected, actual);
    }

    @Test
    public void updateDepositTest(){
        given(depositRepository.getDepositById(anyLong())).willReturn(mockDeposit);
        given(depositRepository.save(any(Deposit.class))).willReturn(mockDeposit);

        ResponseEntity<Deposit> expected = new ResponseEntity<>(mockDeposit, HttpStatus.OK);
        ResponseEntity<Deposit> actual = depositService.updateDeposit(mockDeposit, mockDeposit.getId());

        verify(depositRepository).save(any(Deposit.class));
        assertEquals(expected, actual);
    }

    @Test
    public void deleteDepositById(){
        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        ResponseEntity actual = depositService.deleteDepositById(mockDeposit.getId());

        verify(depositRepository).deleteById(anyLong());
        assertEquals(expected, actual);
    }
}