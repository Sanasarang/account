package com.account.datasource.controller;

import com.account.datasource.model.AccountValidationReq;
import com.account.datasource.model.AccountValidationRsp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/source1")
public class DataSourceController {

    @RequestMapping(
            value = "/validate",
            method = RequestMethod.PUT,
            produces="application/json",
            consumes="application/json"
    )
    public ResponseEntity<AccountValidationRsp> validate(@RequestBody AccountValidationReq accountReq) {
        return new ResponseEntity<AccountValidationRsp>(
                new AccountValidationRsp(false),
                HttpStatus.OK);

    }

}
