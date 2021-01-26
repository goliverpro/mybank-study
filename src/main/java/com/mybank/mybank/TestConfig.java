package com.mybank.mybank;

import com.mybank.mybank.domain.Account;
import com.mybank.mybank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AccountRepository repository;

    @Override
    public void run(String... args) throws Exception{

        Account account = new Account(null, "corrente", 200.00, 100.00);
        Account account2 = new Account(null, "poupança", 500.00, 0.00);
        repository.saveAll(Arrays.asList(account, account2));
    }
}
