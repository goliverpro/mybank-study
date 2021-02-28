package com.mybank.mybank.resources;

import com.mybank.mybank.DTO.ClientDTO;
import com.mybank.mybank.domain.Client;
import com.mybank.mybank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto){
        service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll(){
        List<ClientDTO> clients = service.findAll();
        return ResponseEntity.ok().body(clients);
    }
}
