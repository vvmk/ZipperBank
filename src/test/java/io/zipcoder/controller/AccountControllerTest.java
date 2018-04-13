package io.zipcoder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.singletonList;
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
 * date: 4/11/18
 */

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountController accountController;

    private Account mockAccount;
    private ObjectMapper om = new ObjectMapper();

    @Before
    public void setup() {
        Customer mockCustomer = new Customer();
        mockCustomer.setId(1L);

        mockAccount = new Account();
        mockAccount.setId(1L);
        mockAccount.setCustomer(mockCustomer);
    }

    @Test
    public void getAllAccounts() throws Exception {
        Iterable<Account> accounts = singletonList(mockAccount);
        ResponseEntity<Iterable<Account>> response = new ResponseEntity<>(accounts, OK);

        given(accountController.getAllAccounts())
                .willReturn(response);

        mockMvc.perform(get("/accounts")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAccountById() throws Exception {
        ResponseEntity<Account> response = new ResponseEntity<>(mockAccount, OK);

        given(accountController.getAccountById(mockAccount.getId()))
                .willReturn(response);

        mockMvc.perform(get("/accounts/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAccountsByCustomerId() throws Exception {
        Iterable<Account> accounts = singletonList(mockAccount);
        ResponseEntity<Iterable<Account>> response = new ResponseEntity<>(accounts, OK);

        given(accountController.getAccountsByCustomerId(mockAccount.getCustomer().getId()))
                .willReturn(response);

        mockMvc.perform(get("/customers/1/accounts")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createAccount() throws Exception {
        given(accountController.createAccount(mockAccount, mockAccount.getCustomer().getId()))
                .willReturn(mock(ResponseEntity.class));

        String body = om.writeValueAsString(mockAccount);
        mockMvc.perform(
                post("/customers/1/accounts")
                        .contentType(APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }

    @Test
    public void updateAccount() throws Exception {
        given(accountController.updateAccount(mockAccount, mockAccount.getId()))
                .willReturn(mock(ResponseEntity.class));

        String body = om.writeValueAsString(mockAccount);
        mockMvc.perform(
                put("/accounts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteAccountById() throws Exception {
        mockMvc.perform(delete("/accounts/1"))
                .andExpect(status().isOk());
    }
}