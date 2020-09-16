package com.cyn.account.domain_entities.mapper;

import com.cyn.account.domain_entities.AccountEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountEntityMapper implements RowMapper<AccountEntity> {
    @Override
    public AccountEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setId(resultSet.getLong("id"));
        accountEntity.setAccountNumber(resultSet.getString("account_number"));
        accountEntity.setAlias(resultSet.getString("alias"));
        accountEntity.setCurrency(resultSet.getString("currency"));
        accountEntity.setAmount(resultSet.getFloat("amount"));
        accountEntity.setUserId(resultSet.getString("user_id"));

        return accountEntity;

    }
}
