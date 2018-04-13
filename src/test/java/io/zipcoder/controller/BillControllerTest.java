package io.zipcoder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import io.zipcoder.domain.Customer;
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
import static org.springframework.http.HttpStatus.CREATED;
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

@RunWith(SpringRunner.class)
@WebMvcTest(BillController.class)
public class BillControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BillController billController;

    private Bill mockBill;
    private Account mockAccount;

    private ObjectMapper om = new ObjectMapper();

    @Before
    public void setUp() {
        Customer mockCustomer = new Customer();
        mockCustomer.setId(1L);

        mockAccount = new Account();
        mockAccount.setId(1L);
        mockAccount.setCustomer(mockCustomer);

        mockBill = new Bill();
        mockBill.setId(1L);
        mockBill.setAccount(mockAccount);
        mockBill.setStatus("OVERDUE_AF");
    }

    @Test
    public void getBillsByAccountId() throws Exception {
        Iterable<Bill> bills = singletonList(mockBill);
        ResponseEntity<Iterable<Bill>> response = new ResponseEntity<>(bills, OK);

        given(billController.getBillsByAccountId(mockAccount.getId()))
                .willReturn(response);

        mockMvc.perform(get("/accounts/1/bills")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getBillById() throws Exception {
        ResponseEntity<Bill> response = new ResponseEntity<>(mockBill, OK);

        given(billController.getBillById(mockBill.getId()))
                .willReturn(response);

        mockMvc.perform(get("/bills/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getBillsByCustomerId() throws Exception {
        Iterable<Bill> bills = singletonList(mockBill);
        ResponseEntity<Iterable<Bill>> response = new ResponseEntity<>(bills, OK);

        given(billController.getBillsByCustomerId(mockAccount.getCustomer().getId()))
                .willReturn(response);

        mockMvc.perform(get("/customers/1/bills")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createBill() throws Exception {
        ResponseEntity<Bill> response = new ResponseEntity<>(mockBill, CREATED);

        given(billController.createBill(mockBill, mockAccount.getId()))
                .willReturn(response);

        String body = om.writeValueAsString(mockBill);

        mockMvc.perform(
                post("/accounts/1/bills")
                        .contentType(APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }

    @Test
    public void updateBill() throws Exception {
        ResponseEntity<Bill> response = new ResponseEntity<>(mockBill, OK);

        given(billController.updateBill(mockBill, mockBill.getId()))
                .willReturn(response);

        String body = om.writeValueAsString(mockBill);

        mockMvc.perform(
                put("/bills/1")
                        .contentType(APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteBillById() throws Exception {
        mockMvc.perform(delete("/bills/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}