package io.zipcoder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.domain.Account;
import io.zipcoder.service.interfaces.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * project: zcwbank
 * package: io.zipcoder.controller
 * author: https://github.com/vvmk
 * date: 4/11/18
 */

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    private ObjectMapper om = new ObjectMapper();

    @Before
    public void setup() {
        when(accountService.createAccount(any(Account.class), anyLong())).thenReturn(new ResponseEntity<>(new Account(), HttpStatus.OK));
        when(accountService.createAccount(any(Account.class), anyLong())).thenReturn(new ResponseEntity<>(new Account(), HttpStatus.OK));
    }

    @Test
    public void getAllAccountsOK() throws Exception {
        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAccountByIdOK() throws Exception {
        mockMvc.perform(get("/accounts/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAccountsByCustomerIdOK() throws Exception {
        mockMvc.perform(get("/customers/1/accounts"))
                .andExpect(status().isOk());
    }

    @Test
    public void createAccountOK() throws Exception {
        mockMvc.perform(
                post("/customers/1/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"foo\": \"bar\"}"))
                .andExpect(status().isOk());
    }

    /*@Test
    public void updateAccountOK() throws Exception {
        mockMvc.perform(
                put("/customers/1/accounts")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{ \"foo\": \"bar\"}"))
                .andExpect(status().isOk());
    }*/

    @Test
    public void deleteAccountByIdOK() throws Exception {
        mockMvc.perform(delete("/accounts/1"))
                .andExpect(status().isOk());
    }
}