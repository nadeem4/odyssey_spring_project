package com.cyn.account.repository;

import com.cyn.account.domain_entities.AccountEntity;
import com.cyn.account.domain_entities.mapper.AccountEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<AccountEntity> findAll( String userId ) {
        return jdbcTemplate
                .query("select * from account where id = ?",
                        new Object[] {
                                userId
                        },
                        new AccountEntityMapper());
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from account where id=?", new Object[] { id });
    }

    public int insert(AccountEntity accountEntity) {
        return jdbcTemplate.update(
                "insert into account (user_id, account_number, alias, currency, amount) "
                        + "values(?,  ?, ?, ?, ?)",
                new Object[] {
                        accountEntity.getUserId(),
                        accountEntity.getAccountNumber(),
                        accountEntity.getAlias(),
                        accountEntity.getCurrency(),
                        accountEntity.getAmount()
                });
    }

    public int update(AccountEntity accountEntity, long id) {
        return jdbcTemplate.update(
                "update student "
                        + " set alias = ?, currency = ?, user_id = ?, account_number = ? "
                        + " where id = ?",
                new Object[] {
                        accountEntity.getAlias(),
                        accountEntity.getCurrency(),
                        accountEntity.getUserId(),
                        accountEntity.getAccountNumber(),
                        id
                });
    }

    public int updateAmount(float amt, long accId) {
        return jdbcTemplate.update(
                "update student "
                        + " set ammount = ?"
                        + " where id = ?",
                new Object[] {
                        amt, accId
                });
    }
}
