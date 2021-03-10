package com.mybank.mybank.resources;

import com.mybank.mybank.DTO.AccountDTO;
import com.mybank.mybank.domain.Account;
import com.mybank.mybank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public ResponseEntity<AccountDTO> insert(@RequestBody AccountDTO dto){
        service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> findAll(){
        List<AccountDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
