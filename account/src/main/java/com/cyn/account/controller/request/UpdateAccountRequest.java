package com.cyn.account.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateAccountRequest extends BaseAccountRequest {

    private Integer accountId;
}
