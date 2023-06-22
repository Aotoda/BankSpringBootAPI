package com.example.bank.model.DTOs.request;

import com.example.bank.model.entities.Client;
import com.example.bank.model.entities.Log;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PutClientDto {
    private Client client;
    private Log log;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }
}
