package com.example.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank.model.entities.Client;

public interface MySqlRepo extends JpaRepository<Client,Integer>{
    
}
