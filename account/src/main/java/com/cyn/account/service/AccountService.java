package com.cyn.account.service;


import com.cyn.account.application_entities.account.AccountEntity;
import com.cyn.account.application_entities.mapper.AccountEntityMapper;
import com.cyn.account.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountEntityMapper entityMapper;

    public Integer createAccount(AccountEntity accountEntity) {

        return accountRepository.insert( entityMapper.convertTODomainEntity(accountEntity));
    }

    public Integer updateAccount(AccountEntity accountEntity, long accId) {
        return accountRepository.update( entityMapper.convertTODomainEntity(accountEntity), accId);
    }

    public Integer updateAmount(float amt, long accId) {
        return accountRepository.updateAmount(amt, accId);
    }

    public Integer deleteAccount(long accountId) {
        return accountRepository.deleteById(accountId);
    }


    public List<AccountEntity> getAccounts(String userId) {
        return  accountRepository.findAll(userId)
                .stream()
                .map(entityMapper::convertTOApplicationEntity)
                .collect(Collectors.toUnmodifiableList());
    }



}
