package com.example.bank.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idclients;
    
    private Integer number;
    private String firstname;
    private String lastname;

    public Client(Integer number, String firstname, String lastname){
        this.number = number;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getid(){
        return idclients;
    }

    public Integer getnumber(){
        return number;
    }

    public void setnumber(Integer number){
        this.number = number;
    }

    public String getfirstname(){
        return firstname;
    }

    public void setfirstname(String firstname){
        this.firstname = firstname;
    }

    public String getlastname(){
        return lastname;
    }

    public void setlastname(String lastname){
        this.lastname = lastname;
    }

}