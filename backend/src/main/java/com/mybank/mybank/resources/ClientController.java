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
public class ClientController {

    @Autowired
    private ClientService service;

    @RequestMapping(value = "/insert-client", method=RequestMethod.POST)
    public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto){
        service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/login}").buildAndExpand(dto.getLogin()).toUri();
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value = "/all-clients", method=RequestMethod.GET)
    public ResponseEntity<List<ClientDTO>> findAll(){
        List<ClientDTO> clients = service.findAll();
        return ResponseEntity.ok().body(clients);
    }
}
