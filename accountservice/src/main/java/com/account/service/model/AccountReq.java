package com.account.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountReq {

    @NotBlank(message = "The Account Number is required.")
    @Size(min = 8, max = 16, message = "The length of Account Number must be between 8 and 16 characters.")
    private String accountNumber;
    private List<String> sources = new ArrayList<String>();

}
