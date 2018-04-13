package io.zipcoder.service.implementations;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.BillRepository;
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
 * date: 4/9/18
 */

@RunWith(SpringRunner.class)
public class BillServiceImplTest {

    @InjectMocks
    private BillServiceImpl billService;

    @Mock
    private BillRepository billRepo;

    @Mock
    private AccountRepository accountRepo;

    private Bill mockBill;
    private Account mockAccount;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Customer mockCustomer = new Customer();
        mockCustomer.setId(1L);

        mockAccount = new Account();
        mockAccount.setId(1L);
        mockAccount.setCustomer(mockCustomer);

        mockBill = new Bill();
        mockBill.setId(1L);
        mockBill.setAccount(mockAccount);
    }

    @Test
    public void testGetBillsByAccountId() {
        Iterable<Bill> bills = singletonList(mockBill);
        given(billRepo.findAllByAccount_Id(anyLong()))
                .willReturn(bills);

        ResponseEntity<Iterable<Bill>> expected = new ResponseEntity<>(bills, OK);
        ResponseEntity<Iterable<Bill>> actual = billService.getBillsByAccountId(mockAccount.getId());

        verify(billRepo).findAllByAccount_Id(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetBillById() {
        given(billRepo.findById(anyLong()))
                .willReturn(Optional.of(mockBill));

        ResponseEntity<Bill> expected = new ResponseEntity<>(mockBill, OK);
        ResponseEntity<Bill> actual = billService.getBillById(mockBill.getId());

        verify(billRepo).findById(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetBillsByCustomerId() {
        Iterable<Bill> bills = singletonList(mockBill);
        Long custId = mockAccount.getCustomer().getId();
        given(billRepo.findAllByAccountCustomer_Id(anyLong()))
                .willReturn(bills);

        ResponseEntity<Iterable<Bill>> expected = new ResponseEntity<>(bills, OK);
        ResponseEntity<Iterable<Bill>> actual = billService.getBillsByCustomerId(custId);

        verify(billRepo).findAllByAccountCustomer_Id(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateBill() {
        given(accountRepo.findById(anyLong()))
                .willReturn(Optional.of(mockAccount));

        given(billRepo.save(any(Bill.class)))
                .willReturn(mockBill);

        ResponseEntity<Bill> expected = new ResponseEntity<>(mockBill, CREATED);
        ResponseEntity<Bill> actual = billService.createBill(mockBill, mockAccount.getId());

        verify(billRepo).save(any(Bill.class));
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateBill() {
        given(billRepo.save(any(Bill.class)))
                .willReturn(mockBill);

        ResponseEntity<Bill> expected = new ResponseEntity<>(mockBill, OK);
        ResponseEntity<Bill> actual = billService.updateBill(mockBill, mockBill.getId());

        verify(billRepo).save(any(Bill.class));
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteById() {
        ResponseEntity expected = new ResponseEntity(OK);
        ResponseEntity actual = billService.deleteBillById(mockBill.getId());

        verify(billRepo).deleteById(mockBill.getId());
        assertEquals(expected, actual);
    }
}