package io.zipcoder.controller;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.service.interfaces.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

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
 * package: io.zipcoder.controller
 * author: https://github.com/vvmk
 * date: 4/14/18
 */
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private Customer mockCustomer;
    private Account mockAccount;

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
    public void getCustomerByAccountId() {
        ResponseEntity<Customer> expected = new ResponseEntity<>(mockCustomer, OK);
        given(customerService.getCustomerByAccountId(mockCustomer.getId()))
                .willReturn(expected);

        ResponseEntity<Customer> actual = customerController.getCustomerByAccountId(mockAccount.getId());

        verify(customerService).getCustomerByAccountId(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void getAllCustomers() {
        Iterable<Customer> customers = singletonList(mockCustomer);
        ResponseEntity<Iterable<Customer>> expected = new ResponseEntity<>(customers, OK);
        given(customerService.getAllCustomers())
                .willReturn(expected);

        ResponseEntity<Iterable<Customer>> actual = customerController.getAllCustomers();

        verify(customerService).getAllCustomers();
        assertEquals(expected, actual);
    }

    @Test
    public void getCustomerById() {
        ResponseEntity<Customer> expected = new ResponseEntity<>(mockCustomer, OK);
        given(customerService.getCustomerById(anyLong()))
                .willReturn(expected);

        ResponseEntity<Customer> actual = customerController.getCustomerById(mockCustomer.getId());

        verify(customerService).getCustomerById(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void createCustomer() {
        ResponseEntity<Customer> expected = new ResponseEntity<>(mockCustomer, CREATED);
        given(customerService.createCustomer(any(Customer.class)))
                .willReturn(expected);

        ResponseEntity<Customer> actual = customerController.createCustomer(mockCustomer);

        verify(customerService).createCustomer(any(Customer.class));
        assertEquals(expected, actual);
    }

    @Test
    public void updateCustomer() {
        ResponseEntity<Customer> expected = new ResponseEntity<>(mockCustomer, OK);
        given(customerService.updateCustomer(any(Customer.class), anyLong()))
                .willReturn(expected);

        ResponseEntity<Customer> actual = customerController.updateCustomer(mockCustomer, mockCustomer.getId());

        verify(customerService).updateCustomer(any(Customer.class), anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void deleteCustomerById() {
        ResponseEntity expected = new ResponseEntity(OK);
        given(customerService.deleteCustomerById(anyLong()))
                .willReturn(expected);

        ResponseEntity actual = customerController.deleteCustomer(mockCustomer.getId());

        verify(customerService).deleteCustomerById(anyLong());
        assertEquals(expected, actual);
    }
}