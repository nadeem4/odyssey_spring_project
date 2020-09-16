package com.cyn.account.application_entities.mapper;

import com.cyn.account.domain_entities.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountEntityMapper {

    public AccountEntity convertTODomainEntity(com.cyn.account.application_entities.account.AccountEntity accountEntity) {
        AccountEntity entity = new AccountEntity();

        entity.setAccountNumber(accountEntity.getAccountNumber());
        entity.setAlias(accountEntity.getAlias());
        entity.setAmount(accountEntity.getAmount());
        entity.setCurrency(accountEntity.getCurrency());
        entity.setUserId(accountEntity.getUserId());

        return  entity;
    }

    public com.cyn.account.application_entities.account.AccountEntity convertTOApplicationEntity(AccountEntity accountEntity) {
        com.cyn.account.application_entities.account. AccountEntity entity = new com.cyn.account.application_entities.account.AccountEntity();

        entity.setAccountNumber(accountEntity.getAccountNumber());
        entity.setAlias(accountEntity.getAlias());
        entity.setAmount(accountEntity.getAmount());
        entity.setCurrency(accountEntity.getCurrency());
        entity.setUserId(accountEntity.getUserId());

        return  entity;
    }
}
