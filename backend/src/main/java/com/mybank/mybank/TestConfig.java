package com.mybank.mybank;

import com.mybank.mybank.domain.Account;
import com.mybank.mybank.domain.Client;
import com.mybank.mybank.repositories.AccountRepository;
import com.mybank.mybank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception{


        Account account = new Account(null, "corrente", 200.00, 100.00);
        Account account2 = new Account(null, "poupança", 500.00, 0.00);
        Account account3 = new Account(null, "corrente", 500.00, 1200.00);
        Account account4 = new Account(null, "poupança", 900.00, 90.00);

        repository.saveAll(Arrays.asList(account, account2,account3,account4));

        Client client1 = new Client("maria.brown", "Maria Brown", "1234567", null, "99999999", new BCryptPasswordEncoder().encode("123"));
        Client client2 = new Client("joao.brown", "João Brown", "7654321", null, "88888888", new BCryptPasswordEncoder().encode("123"));

        client1.getAccount().addAll(Arrays.asList(account, account2));
        client2.getAccount().addAll(Arrays.asList(account3, account4));

        clientRepository.saveAll(Arrays.asList(client1, client2));

        account.setClient(client1);
        account2.setClient(client1);
        account3.setClient(client2);
        account4.setClient(client2);
        repository.saveAll(Arrays.asList(account, account2,account3,account4));

        List<Client> client3 = clientRepository.findAll();
        for(Client c : client3){
            System.out.println(client1.getClientPassword());
        }
        System.out.println("test" + client1.getClientPassword() );

    }
}
