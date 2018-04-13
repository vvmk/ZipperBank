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
public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepo;

    @Mock
    private AccountRepository accountRepo;

    private Customer mockCustomer;
    private Account mockAccount;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockCustomer = new Customer();
        mockCustomer.setId(1L);

        mockAccount = new Account();
        mockAccount.setId(1L);
        mockAccount.setCustomer(mockCustomer);
    }

    @Test
    public void getCustomerByAccountId() {
        given(accountRepo.findById(anyLong()))
                .willReturn(Optional.of(mockAccount));

        given(customerRepo.findById(mockCustomer.getId()))
                .willReturn(Optional.of(mockCustomer));

        ResponseEntity<Customer> expected = new ResponseEntity<>(mockCustomer, OK);
        ResponseEntity<Customer> actual = customerService.getCustomerByAccountId(mockAccount.getId());

        verify(accountRepo).findById(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void getAllCustomers() {
        Iterable<Customer> customers = singletonList(mockCustomer);
        given(customerRepo.findAll())
                .willReturn(customers);

        ResponseEntity<Iterable<Customer>> expected = new ResponseEntity<>(customers, OK);
        ResponseEntity<Iterable<Customer>> actual = customerService.getAllCustomers();

        verify(customerRepo).findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void getCustomerById() {
        given(customerRepo.findById(anyLong()))
                .willReturn(Optional.of(mockCustomer));

        ResponseEntity<Customer> expected = new ResponseEntity<>(mockCustomer, OK);
        ResponseEntity<Customer> actual = customerService.getCustomerById(mockCustomer.getId());

        verify(customerRepo).findById(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    public void createCustomer() {
        given(customerRepo.save(any(Customer.class)))
                .willReturn(mockCustomer);

        ResponseEntity<Customer> expected = new ResponseEntity<>(mockCustomer, CREATED);
        ResponseEntity<Customer> actual = customerService.createCustomer(mockCustomer);

        verify(customerRepo).save(any(Customer.class));
        assertEquals(expected, actual);
    }

    @Test
    public void updateCustomer() {
        given(customerRepo.existsById(anyLong()))
                .willReturn(true);
        
        given(customerRepo.save(any(Customer.class)))
                .willReturn(mockCustomer);

        ResponseEntity<Customer> expected = new ResponseEntity<>(mockCustomer, OK);
        ResponseEntity<Customer> actual = customerService.updateCustomer(mockCustomer, mockCustomer.getId());

        verify(customerRepo).save(any(Customer.class));
        assertEquals(expected, actual);
    }

    @Test
    public void deleteCustomerById() {
    }
}