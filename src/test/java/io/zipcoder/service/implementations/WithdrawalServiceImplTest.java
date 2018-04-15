package io.zipcoder.service.implementations;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        mockAccount.setId(4444L);

        mockWithdrawal = new Withdrawal();
        mockWithdrawal.setAmount(500.00);
        mockWithdrawal.setId(666L);
        mockWithdrawal.setAccount(mockAccount);
    }

    @Test
     public void testGetAllWithdrawalByAccountId(){
        // given
        List<Withdrawal> withdrawals = new ArrayList<>();
        withdrawals.add(mockWithdrawal);

        given(withdrawalRepoMock.findAllByAccount_Id(anyLong()))
                .willReturn(withdrawals);

        // when
        ResponseEntity<Iterable<Withdrawal>> expected = new ResponseEntity<>(withdrawals, HttpStatus.OK);
        ResponseEntity<Iterable<Withdrawal>> actual = withdrawalServiceImpl.getAllWithdrawalsByAccountId(mockAccount.getId());

        // then
        verify(withdrawalRepoMock).findAllByAccount_Id(anyLong());
        assertEquals(expected, actual);
    }


    @Test
    public void testGetWithdrawalById(){
        List<Withdrawal> withdrawals = new ArrayList<>();
        withdrawals.add(mockWithdrawal);

        given(withdrawalRepoMock.getById(anyLong()))
                .willReturn(mockWithdrawal);

        // when
        ResponseEntity<Withdrawal> expected = new ResponseEntity<>(mockWithdrawal, HttpStatus.OK);
        ResponseEntity<Withdrawal> actual = withdrawalServiceImpl.getWithdrawalById(mockWithdrawal.getId());

        // then
        verify(withdrawalRepoMock).getById(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateWithdrawal(){

        given(withdrawalRepoMock.save(any(Withdrawal.class)))
                .willReturn(mockWithdrawal);

        ResponseEntity<Withdrawal> expected = new ResponseEntity<>(mockWithdrawal, CREATED);
        ResponseEntity<Withdrawal> actual = withdrawalServiceImpl.createWithdrawal(mockWithdrawal, mockAccount.getId());

        verify(withdrawalRepoMock).save(any(Withdrawal.class));
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateWithdrawal() {
        given(withdrawalRepoMock.save(any(Withdrawal.class)))
                .willReturn(mockWithdrawal);

        ResponseEntity<Withdrawal> expected = new ResponseEntity<>(mockWithdrawal, OK);
        ResponseEntity<Withdrawal> actual = withdrawalServiceImpl.updateWithdrawal(mockWithdrawal, mockWithdrawal.getId());

        verify(withdrawalRepoMock).save(any(Withdrawal.class));
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteWithdrawal() {
        ResponseEntity expected = new ResponseEntity(OK);
        ResponseEntity actual = withdrawalServiceImpl.deleteWithdrawalById(mockWithdrawal.getId());

        verify(withdrawalRepoMock).deleteById(mockWithdrawal.getId());
        assertEquals(expected, actual);
    }


}