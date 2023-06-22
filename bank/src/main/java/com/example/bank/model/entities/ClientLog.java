package com.example.bank.model.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs")
public class ClientLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idlogs;

    private String message;
    private LocalDateTime timeStamp;
    
    public ClientLog(String message, LocalDateTime timeStamp){
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getMess(){
        return message;
    }

    public void setMess(String message){
        this.message = message;
    }

    public LocalDateTime getTime(){
        return timeStamp;
    }

    public void setTime(LocalDateTime timeStamp){
        this.timeStamp = timeStamp;
    }

}
