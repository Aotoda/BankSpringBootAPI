package com.example.bank.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "logs")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idlogs;

    private String message;
    private String timeStamp;

    public ClientLog(String message, String timeStamp){
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
