package com.cyn.account.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseAccountRequest {
    private String userId;

    private String accountNumber;

    private String alias;

    private String currency;

    private Float amount;
}
