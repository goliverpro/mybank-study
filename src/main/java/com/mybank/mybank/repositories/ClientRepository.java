package com.mybank.mybank.repositories;

import com.mybank.mybank.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
