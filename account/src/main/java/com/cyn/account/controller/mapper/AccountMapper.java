package com.cyn.account.controller.mapper;

import com.cyn.account.application_entities.account.AccountEntity;
import com.cyn.account.controller.request.BaseAccountRequest;
import com.cyn.account.controller.request.CreateAccountRequest;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountEntity convertToApplicationEntity(BaseAccountRequest accountRequest) {
        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setAccountNumber(accountRequest.getAccountNumber());
        accountEntity.setAlias(accountRequest.getAlias());
        accountEntity.setAmount(accountRequest.getAmount());
        accountEntity.setCurrency(accountRequest.getCurrency());
        accountEntity.setUserId(accountRequest.getUserId());

        return  accountEntity;
    }
}
