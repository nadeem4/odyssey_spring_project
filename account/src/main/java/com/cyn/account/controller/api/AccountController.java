package com.cyn.account.controller.api;


import com.cyn.account.application_entities.account.AccountEntity;
import com.cyn.account.application_entities.response.SuccessEntity;
import com.cyn.account.controller.mapper.AccountMapper;
import com.cyn.account.controller.request.CreateAccountRequest;
import com.cyn.account.controller.request.UpdateAccountRequest;
import com.cyn.account.controller.request.UpdateAmountRequest;
import com.cyn.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountMapper accountMapper;

    @PostMapping(path = "create-account", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuccessEntity> createAccount(@RequestBody CreateAccountRequest createAccountRequest) {

        Integer id = accountService.createAccount(accountMapper.convertToApplicationEntity(createAccountRequest));

        SuccessEntity res = new SuccessEntity();

        res.setAccountId(id);
        res.setMessage("Account has been successfully created");

        return ResponseEntity.ok(res);
    }

    @PutMapping(path = "update-account", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuccessEntity> updateAccount(@RequestBody UpdateAccountRequest updateAccountRequest) {
        Integer id = accountService.updateAccount(
                accountMapper.convertToApplicationEntity(updateAccountRequest),
                updateAccountRequest.getAccountId()
        );
        SuccessEntity res = new SuccessEntity();

        res.setAccountId(id);
        res.setMessage("Account has been successfully updated");
        return ResponseEntity.ok(new SuccessEntity());
    }

    @PutMapping(path = "update-amount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuccessEntity> updateAmount(@RequestParam UpdateAmountRequest updateAmtRequest) {
        Integer id = accountService.updateAmount(
                updateAmtRequest.getAmount(),
                updateAmtRequest.getAccId()
        );
        SuccessEntity res = new SuccessEntity();

        res.setAccountId(id);
        res.setMessage("Account has been successfully updated");
        return ResponseEntity.ok(new SuccessEntity());
    }


    @DeleteMapping(path = "delete-account", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuccessEntity> deleteAccount(@RequestParam long accountId) {

        accountService.deleteAccount(accountId);
        return ResponseEntity.ok(new SuccessEntity());
    }


    @GetMapping(path = "list-accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AccountEntity>> listAccounts() {
        String userId = null;
        return ResponseEntity.ok(accountService.getAccounts(userId));
    }


    @GetMapping(path = "get-accounts-by-userid", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AccountEntity>> listAccount(@RequestParam String userId) {
        ;
        return ResponseEntity.ok(accountService.getAccounts(userId));
    }


}
