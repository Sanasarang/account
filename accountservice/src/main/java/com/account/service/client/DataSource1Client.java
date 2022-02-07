package com.account.service.client;

import com.account.service.client.apicontract.AccountValidationReq;
import com.account.service.client.apicontract.AccountValidationRsp;
import com.account.service.factory.DataSource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="DATASOURCE1-SERVICE")
public interface DataSource1Client extends DataSource{

    @RequestMapping(
            value = "/source1/validate",
            method = RequestMethod.PUT,
            produces="application/json",
            consumes="application/json"
    )
    public ResponseEntity<AccountValidationRsp> validate(AccountValidationReq accountReq);

}
