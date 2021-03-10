package com.mybank.mybank.security;

import com.mybank.mybank.domain.Client;
import com.mybank.mybank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class ImpUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository cl;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Client client = cl.findByLogin(login);
        if(login == null){
            throw new UsernameNotFoundException("Usuario não encontrado!");
        }
        return client;
    }
}
