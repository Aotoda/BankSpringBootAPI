package com.example.bank.model.DTOs.request;

import ch.qos.logback.core.net.server.Client;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClientDto {
    @NoArgsConstructor
    @AllArgsConstructor
    public class PostClientDto {
        public String who;
        public Client client;

        
    }
    @NoArgsConstructor
    @AllArgsConstructor
     class GetClientDto {
        public int where;
    }
}