package com.mybank.mybank.resources;

import com.mybank.mybank.domain.Account;
import com.mybank.mybank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    public ResponseEntity<List<Account>> findAll(){
        List<Account> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
