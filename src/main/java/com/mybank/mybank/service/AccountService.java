package com.mybank.mybank.service;

import com.mybank.mybank.DTO.AccountDTO;
import com.mybank.mybank.domain.Account;
import com.mybank.mybank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public AccountDTO insert(AccountDTO dto){
        Account obj = new Account(null, dto.getTypeAccount(), dto.getBalance(), dto.getBoundary());
        obj = repository.save(obj);
        return new AccountDTO(obj);
    }
    @Transactional(readOnly = true)
    public List<AccountDTO> findAll(){
        List<Account> list = repository.findAll();
        return list.stream().map(x -> new AccountDTO(x)).collect(Collectors.toList());
    }


}
