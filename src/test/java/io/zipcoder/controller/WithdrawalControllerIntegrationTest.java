package io.zipcoder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Withdrawal;
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
@WebMvcTest(WithdrawalController.class)
public class WithdrawalControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WithdrawalController withdrawalController;

    private Withdrawal mockWithdrawal;
    private Account mockAccount;

    private String mockWithdrawalJson;

    @Before
    public void setUp() throws Exception {
        mockAccount = new Account();
        mockAccount.setId(1L);

        mockWithdrawal = new Withdrawal();
        mockWithdrawal.setId(1L);

        mockWithdrawalJson = new ObjectMapper().writeValueAsString(mockWithdrawal);
    }

    @Test
    public void getAllWithdrawalsByAccountId() throws Exception {
        Iterable<Withdrawal> withdrawals = singletonList(mockWithdrawal);
        ResponseEntity<Iterable<Withdrawal>> response = new ResponseEntity<>(withdrawals, OK);

        given(withdrawalController.getAllWithdrawalsByAccountId(mockAccount.getId()))
                .willReturn(response);

        mockMvc.perform(get("/accounts/1/withdrawals")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getWithdrawalById() throws Exception {
        ResponseEntity<Withdrawal> response = new ResponseEntity<>(mockWithdrawal, OK);

        given(withdrawalController.getWithdrawalById(mockWithdrawal.getId()))
                .willReturn(response);

        mockMvc.perform(get("/withdrawals/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createWithdrawal() throws Exception {
        given(withdrawalController.createWithdrawal(mockWithdrawal, mockAccount.getId()))
                .willReturn(mock(ResponseEntity.class));

        mockMvc.perform(
                post("/accounts/1/withdrawal")
                        .contentType(APPLICATION_JSON)
                        .content(mockWithdrawalJson))
                .andExpect(status().isOk());
    }

    @Test
    public void updateWithdrawal() throws Exception {
        given(withdrawalController.updateWithdrawal(mockWithdrawal, mockWithdrawal.getId()))
                .willReturn(mock(ResponseEntity.class));

        mockMvc.perform(
                put("/withdrawals/1")
                        .contentType(APPLICATION_JSON)
                        .content(mockWithdrawalJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteWithdrawalById() throws Exception {
        mockMvc.perform(delete("/withdrawals/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}