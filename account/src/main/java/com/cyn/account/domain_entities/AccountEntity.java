package com.cyn.account.domain_entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountEntity {

    private Long id;

    private String userId;

    private String accountNumber;

    private String alias;

    private String currency;

    private Float amount;
}
