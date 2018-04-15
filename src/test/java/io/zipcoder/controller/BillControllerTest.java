package io.zipcoder.controller;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import io.zipcoder.service.interfaces.BillService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

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
 * package: io.zipcoder.controller
 * author: https://github.com/vvmk
 * date: 4/14/18
 */

@RunWith(SpringRunner.class)
public class BillControllerTest {

    @Mock
    private BillService billService;

    @InjectMocks
    private BillController billController;

    private Bill mockBill;
    private Account mockAccount;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockAccount = new Account();
        mockAccount.setId(1L);

        mockBill = new Bill();
        mockBill.setId(1L);
        mockBill.setAccount(mockAccount);

    }

    @Test
    public void testGetBillsByAccountId() {
        Iterable<Bill> bills = singletonList(mockBill);
        ResponseEntity<Iterable<Bill>> expected = new ResponseEntity<>(bills, OK);
        given(billService.getBillsByAccountId(anyLong()))
                .willReturn(expected);

        ResponseEntity<Iterable<Bill>> actual = billController.getBillsByAccountId(mockAccount.getId());

        verify(billService).getBillsByAccountId(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetBillById() {
        ResponseEntity<Bill> expected = new ResponseEntity<>(mockBill, OK);
        given(billService.getBillById(anyLong()))
                .willReturn(expected);

        ResponseEntity<Bill> actual = billController.getBillById(mockBill.getId());

        verify(billService).getBillById(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetBillsByCustomerId() {
        Iterable<Bill> bills = singletonList(mockBill);
        ResponseEntity<Iterable<Bill>> expected = new ResponseEntity<>(bills, OK);
        given(billService.getBillsByCustomerId(anyLong()))
                .willReturn(expected);

        ResponseEntity<Iterable<Bill>> actual = billController.getBillsByCustomerId(1L);

        verify(billService).getBillsByCustomerId(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateBill() {
        ResponseEntity<Bill> expected = new ResponseEntity<>(mockBill, CREATED);
        given(billService.createBill(any(Bill.class), anyLong()))
                .willReturn(expected);

        ResponseEntity<Bill> actual = billController.createBill(mockBill, mockAccount.getId());

        verify(billService).createBill(any(Bill.class), anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateBill() {
        ResponseEntity<Bill> expected = new ResponseEntity<>(mockBill, OK);
        given(billService.updateBill(any(Bill.class), anyLong()))
                .willReturn(expected);

        ResponseEntity<Bill> actual = billController.updateBill(mockBill, mockBill.getId());

        verify(billService).updateBill(any(Bill.class), anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteById() {
        ResponseEntity expected = new ResponseEntity(OK);
        given(billService.deleteBillById(anyLong()))
                .willReturn(expected);

        ResponseEntity actual = billController.deleteBillById(mockBill.getId());

        verify(billService).deleteBillById(mockBill.getId());
        assertEquals(expected, actual);
    }
}