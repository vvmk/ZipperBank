package io.zipcoder.controller;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
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
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

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

    @Before
    public void setUp() {
        mockAccount = new Account();
        mockAccount.setId(1L);

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
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].status", is(mockBill.getStatus())));
    }

    @Test
    public void getBillById() throws Exception {
    }

    @Test
    public void getBillsByCustomerId() throws Exception {
    }

    @Test
    public void createBill() throws Exception {
    }

    @Test
    public void updateBill() throws Exception {
    }

    @Test
    public void deleteBillById() throws Exception {
    }
}