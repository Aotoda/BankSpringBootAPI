package com.example.bank.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.DTOs.request.ClientDto;
import com.example.bank.model.DTOs.request.PutClientDto;
import com.example.bank.model.DTOs.request.ClientDto.PostClientDto;
import com.example.bank.model.entities.Client;
import com.example.bank.model.entities.ClientLog;
import com.example.bank.model.entities.Log;
import com.example.bank.repo.ClientLogRepo;
import com.example.bank.repo.DogRepo;
import com.example.bank.repo.MySqlRepo;

@RestController
public class BankController {
    
    @Autowired
    MySqlRepo mySqlRepo;

    @Autowired
    ClientLogRepo logRepo;

    @Autowired
    DogRepo dogRepo;

    @GetMapping("/get-all-Clients")
    public List<Client> getAllClients(){

        return mySqlRepo.findAll();

    }

    @GetMapping("/get-Client/{identity}")
    public Client getSingleClients(@PathVariable("identity") Integer identity){

        return mySqlRepo.findById(identity).get();

    }

    @DeleteMapping("/remove/{identity}")
    public boolean removeRow(@PathVariable("identity") Integer identity){
        if(!mySqlRepo.findById(identity).equals(Optional.empty())){
            mySqlRepo.deleteById(identity);
            String message = "Removed row " + identity + "!";
            logRepo.save(new ClientLog(message, LocalDateTime.now()));
            return true;
        }
        return false;
    }

    @PutMapping("/BupdateDto/{identity}")
    public Client updateDto(@PathVariable("identity") Integer identity, @RequestBody PutClientDto body){
        Client current = mySqlRepo.findById(identity).get();
        Client client = body.getClient();
        current.setnumber(client.getnumber());
        current.setfirstname(client.getfirstname());
        current.setlastname(client.getlastname());

        Log log = body.getLog(); 
        String message = "Updated row " + identity + "!";
        log.setMess(message);
        
        dogRepo.save(log);
        return mySqlRepo.save(client);
    }

    @PutMapping("/update/{identity}")
    public Client updateRow(@PathVariable("identity") Integer identity, @RequestBody Client body){
        Client current = mySqlRepo.findById(identity).get();
        current.setnumber(body.getnumber());
        current.setfirstname(body.getfirstname());
        current.setlastname(body.getlastname());

        String message = "Updated row " + identity + "!";
        logRepo.save(new ClientLog(message, LocalDateTime.now()));
        return mySqlRepo.save(current);
    }


    @PostMapping("/create")
    public Client createRow(@RequestBody Client body) {
        mySqlRepo.save(body);
        String message = "Created row " + body.getid() + "!";
        logRepo.save(new ClientLog(message, LocalDateTime.now()));
        return body;
    }

    ClientDto clientDto = new ClientDto();
    PostClientDto pcd = clientDto.new PostClientDto();

    @PostMapping("/createOneDto")
    public String createOneDto(@RequestBody PostClientDto body) {

        return body.who;
    }

    @GetMapping("/getOneDto")
    public <GetClientDto> GetClientDto getOneDto(@RequestBody GetClientDto body) {
        return body;
    }

}