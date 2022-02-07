package com.account.service.service;

import com.account.service.model.AccountReq;
import com.account.service.model.AccountRsp;

public interface AccountService {

    public abstract AccountRsp validate(AccountReq accountReq);

}
