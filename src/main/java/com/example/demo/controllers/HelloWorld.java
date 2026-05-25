package com.example.demo.controllers;

import com.example.demo.models.MilitaryPost;
import com.example.demo.models.Officer;
import com.example.demo.repositories.MilitaryPostRepo;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
public class HelloWorld {
    @Resource
    private MilitaryPostRepo militaryPostRepo;

@GetMapping("/hello")
    public ResponseEntity<String>  sayHello(){
        return new ResponseEntity<>( "Hello, World", HttpStatus.OK) ;
    }


    @PostMapping("/officer")
    public ResponseEntity<Officer> getStaticOfficer(){
    Officer officer = new Officer();
//    officer.setId(1L);
    officer.setFirstName("John");
    officer.setLastName("Doe");
    officer.setMilitaryNumber(123456);
    officer.setEnabled(true);
    officer.setActivationDate(LocalDateTime.of(2000,10,10,10,10));
    return new ResponseEntity<>(officer, HttpStatus.OK);
    }

    @PostMapping("/poste")
    public ResponseEntity<MilitaryPost> savePoste(@RequestBody MilitaryPost poste){
        if (poste!=null){
            militaryPostRepo.save(poste);
        }
        return new ResponseEntity<MilitaryPost>(poste, HttpStatus.OK);
    }


}
