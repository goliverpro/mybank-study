package com.mybank.mybank.service;

import com.mybank.mybank.domain.Client;
import com.mybank.mybank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client insert(Client obj){

        return repository.save(obj);
    }

    public List<Client> findAll(){
        List<Client> list = repository.findAll();
        return list;
    }

}
