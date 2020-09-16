package com.cyn.authorization.controller;


import com.cyn.authorization.utils.PermissionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class AuthorizationController {

    @Autowired
    private PermissionUtils permissionUtils;

    @PostMapping(path = "get-permissions")
    public ResponseEntity <List<String> >getPermissions(@RequestBody List<String> roles) {
        return ResponseEntity.ok(
                permissionUtils.getPermssions(roles)
        );
    }
}
