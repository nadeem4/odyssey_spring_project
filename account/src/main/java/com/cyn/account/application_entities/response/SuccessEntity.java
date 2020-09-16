package com.cyn.account.application_entities.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SuccessEntity {

    private long accountId;

    private String message;

    private String requestId;

}
