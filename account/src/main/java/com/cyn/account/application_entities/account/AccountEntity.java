package com.cyn.account.application_entities.account;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountEntity {

    private String userId;

    private String accountNumber;

    private String alias;

    private String currency;

    private Float amount;
}
