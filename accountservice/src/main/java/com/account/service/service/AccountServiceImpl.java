package com.account.service.service;

import com.account.service.client.apicontract.AccountValidationReq;
import com.account.service.client.apicontract.AccountValidationRsp;
import com.account.service.factory.DataSource;
import com.account.service.factory.DataSourceFactory;
import com.account.service.model.AccountReq;
import com.account.service.model.AccountRsp;
import com.account.service.model.SourceValidation;
import com.account.service.util.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    DataSourceFactory dataSourceFactory;

    @Autowired
    DataSource dataSource;


    @Override
    public AccountRsp validate(AccountReq accountReq) {
        List<SourceValidation> sourceValidations = new ArrayList<SourceValidation>();
        //Check if request contains sources else query all sources
        var sources = accountReq.getSources().isEmpty() ? Stream.of(SourceType.values())
                .map(Enum::name)
                .collect(Collectors.toList()) : accountReq.getSources();
        for (String source : sources) {
            //Dynamically load dataSources Feign client based on sources using
            //Factory pattern
             dataSource = dataSourceFactory
                     .getDataSource(SourceType.valueOf(source.toUpperCase()));
             //Validate account number against the data source using feign
            AccountValidationRsp validate =
                    dataSource.validate(
                            new AccountValidationReq(accountReq.getAccountNumber())).getBody();
            //Construct response object for each data sources
            sourceValidations.add(new SourceValidation(source,validate.isValid()));
        }
        return new AccountRsp(sourceValidations);
    }
}
