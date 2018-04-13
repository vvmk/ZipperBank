package io.zipcoder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import org.apache.coyote.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * project: zcwbank
 * package: io.zipcoder.controller
 * author: https://github.com/vvmk
 * date: 4/12/18
 */

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerController customerController;

    private Account mockAccount;
    private Customer mockCustomer;
    private ObjectMapper om = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        mockAccount = new Account();
        mockAccount.setId(1L);

        mockCustomer = new Customer();
        mockCustomer.setId(1L);
        mockCustomer.setAccounts(singletonList(mockAccount));
    }

    @Test
    public void getCustomerByAccountId() throws Exception {
        ResponseEntity<Customer> response = new ResponseEntity<>(mockCustomer, OK);

        given(customerController.getCustomerByAccountId(mockAccount.getId()))
                .willReturn(response);

        mockMvc.perform(get("/accounts/1/customer")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllCustomers() throws Exception {
        Iterable<Customer> customers = singletonList(mockCustomer);
        ResponseEntity<Iterable<Customer>> response = new ResponseEntity<>(customers, OK);

        given(customerController.getAllCustomers())
                .willReturn(response);

        mockMvc.perform(get("/customers")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getCustomerById() throws Exception {
        given(customerController.getCustomerByAccountId(mockCustomer.getId()))
                .willReturn(mock(ResponseEntity.class));

        mockMvc.perform(get("/customers/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createCustomer() throws Exception {
        given(customerController.createCustomer(mockCustomer))
                .willReturn(mock(ResponseEntity.class));

        String body = om.writeValueAsString(mockCustomer);
        mockMvc.perform(
                post("/customers")
                .contentType(APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());
    }

    @Test
    public void updateCustomer() throws Exception {
        given(customerController.updateCustomer(mockCustomer, mockCustomer.getId()))
                .willReturn(mock(ResponseEntity.class));

        String body = om.writeValueAsString(mockCustomer);
        mockMvc.perform(
                put("/customers/1")
                .contentType(APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCustomer() throws Exception {
        mockMvc.perform(delete("/customers/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}