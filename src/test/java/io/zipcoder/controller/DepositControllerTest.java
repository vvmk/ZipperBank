package io.zipcoder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Deposit;
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
@WebMvcTest(DepositController.class)
public class DepositControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepositController depositController;

    private Deposit mockDeposit;
    private Account mockAccount;

    private ObjectMapper om = new ObjectMapper();

    @Before
    public void setUp() {
        mockAccount = new Account();
        mockAccount.setId(1L);

        mockDeposit = new Deposit();
        mockDeposit.setId(1L);


    }

    @Test
    public void getAllDepositsByAccountId() throws Exception {
        Iterable<Deposit> deposits = singletonList(mockDeposit);
        ResponseEntity<Iterable<Deposit>> response = new ResponseEntity<>(deposits, OK);

        given(depositController.getAllDepositsByAccountId(mockAccount.getId()))
                .willReturn(response);

        mockMvc.perform(get("/accounts/1/deposits")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getDepositById() throws Exception {
        ResponseEntity<Deposit> response = new ResponseEntity<>(mockDeposit, OK);

        given(depositController.getDepositById(mockDeposit.getId()))
                .willReturn(response);

        mockMvc.perform(get("/deposits/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createDeposit() throws Exception {
        given(depositController.createDeposit(mockDeposit, mockAccount.getId()))
                .willReturn(mock(ResponseEntity.class));

        String body = om.writeValueAsString(mockDeposit);
        mockMvc.perform(
                post("/accounts/1/deposits")
                        .contentType(APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }

    @Test
    public void updateDeposit() throws Exception {
        given(depositController.updateDeposit(mockDeposit, mockDeposit.getId()))
                .willReturn(mock(ResponseEntity.class));

        String body = om.writeValueAsString(mockDeposit);
        mockMvc.perform(
                put("/deposits/1")
                        .contentType(APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteDepositById() throws Exception {
        mockMvc.perform(delete("/deposits/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}