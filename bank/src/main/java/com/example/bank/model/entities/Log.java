package com.example.bank.model.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "logs")
@NoArgsConstructor
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idlogs;

    private String message;
    String timeStamp;

    public Log(String message, LocalDateTime timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp.toString();
    }

    public String getMess() {
        return message;
    }

    public void setMess(String message) {
        this.message = message;
    }

    public String getTime() {
        return timeStamp;
    }

    public void setTime(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp.toString();
    }
}