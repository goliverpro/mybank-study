package com.mybank.mybank.service;

import com.mybank.mybank.DTO.AccountDTO;
import com.mybank.mybank.DTO.ClientDTO;
import com.mybank.mybank.domain.Account;
import com.mybank.mybank.domain.Client;
import com.mybank.mybank.repositories.AccountRepository;
import com.mybank.mybank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private AccountRepository accountRepository;

    public ClientDTO insert(ClientDTO dto){
        Client obj = new Client(null, dto.getName(), dto.getDocument(), dto.getBirthDate(), dto.getCellPhone());
        obj = repository.save(obj);
        for(AccountDTO accountDTO : dto.getAccount()){
            Account account = new Account(accountDTO.getId(), accountDTO.getTypeAccount(), accountDTO.getBalance(), accountDTO.getBoundary());
            account.setClient(obj);
            accountRepository.save(account);
        }
        return new ClientDTO(obj);
    }

    public List<ClientDTO> findAll(){
        List<Client> list = repository.findAll();
        return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
    }

}
