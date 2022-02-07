package com.account.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRsp {

    private List<SourceValidation> sources = new ArrayList<SourceValidation>();

}
