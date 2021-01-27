package com.mybank.mybank.service;

import com.mybank.mybank.domain.Account;
import com.mybank.mybank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account insert(Account obj){

        return repository.save(obj);
    }
    public List<Account> findAll(){
        return repository.findAll();
    }


}
