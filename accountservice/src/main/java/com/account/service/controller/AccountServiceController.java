package com.account.service.controller;

import com.account.service.model.AccountReq;
import com.account.service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AccountServiceController {

    @Autowired
    AccountService accountService;

    @RequestMapping(
            value = "/v1/api/account/validate",
            method = RequestMethod.PUT,
            produces="application/json",
            consumes="application/json"
    )
    public ResponseEntity<Object> validateV1(@Valid @RequestBody AccountReq accountReq) {
        return new ResponseEntity<>(accountService.validate(accountReq), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/v2/api/account/validate",
            method = RequestMethod.PUT,
            produces="application/json",
            consumes="application/json"
    )
    public ResponseEntity<Object> validateV2(@Valid @RequestBody AccountReq accountReq) {
        return new ResponseEntity<>(accountService.validate(accountReq), HttpStatus.OK);
    }
}
