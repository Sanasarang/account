package com.account.service.controller;

import com.account.service.model.AccountReq;
import com.account.service.model.AccountRsp;
import com.account.service.model.SourceValidation;
import com.account.service.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountServiceController.class)
public class AccountServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AccountService service;

    @Test
    public void validateAccountWithSourcesV1Test()
            throws Exception {
        AccountReq accountReq = new AccountReq("12345678",
                Arrays.asList("source1"));

        AccountRsp accountRsp = new AccountRsp(Arrays.asList(
                new SourceValidation("SOURCE1", false)));

        BDDMockito.given(service.validate(accountReq)).willReturn(accountRsp);

        mvc.perform(put("/v1/api/account/validate")
                        .content(asJsonString(accountReq))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sources[0].source").value("SOURCE1"))
                .andExpect(jsonPath("$.sources[0].valid").value(false));
    }

    @Test
    public void validateAccountWithSourcesV2Test()
            throws Exception {
        AccountReq accountReq = new AccountReq("12345678",
                Arrays.asList("source3"));

        AccountRsp accountRsp = new AccountRsp(Arrays.asList(
                new SourceValidation("SOURCE3", false)));

        BDDMockito.given(service.validate(accountReq)).willReturn(accountRsp);

        mvc.perform(put("/v2/api/account/validate")
                        .content(asJsonString(accountReq))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sources[0].source").value("SOURCE3"))
                .andExpect(jsonPath("$.sources[0].valid").value(false));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
