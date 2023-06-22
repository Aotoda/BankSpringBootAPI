package com.example.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank.model.entities.Log;

public interface DogRepo extends JpaRepository<Log,Integer>{

}