package com.account.service.factory;

import com.account.service.client.apicontract.AccountValidationReq;
import com.account.service.client.apicontract.AccountValidationRsp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface DataSource {

    @RequestMapping(
            method = RequestMethod.PUT,
            produces="application/json",
            consumes="application/json")
    public ResponseEntity<AccountValidationRsp> validate(AccountValidationReq req);
}
