package com.example.demo.controllers;

import com.example.demo.models.MilitaryPost;
import com.example.demo.models.Officer;
import com.example.demo.repositories.MilitaryPostRepo;
import com.example.demo.services.OfficerService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class HelloWorld {
    @Resource
    private MilitaryPostRepo militaryPostRepo;


    private final OfficerService officerService;
    public HelloWorld(OfficerService officerService) {
        this.officerService = officerService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String>  sayHello(){
        return new ResponseEntity<>( "Hello, World", HttpStatus.OK) ;
    }


//    @PostMapping("/officer")
//    public ResponseEntity<Officer> getStaticOfficer(){
//    Officer officer = new Officer();
////    officer.setId(1L);
//    officer.setFirstName("John");
//    officer.setLastName("Doe");
//    officer.setMilitaryNumber(123456);
//    officer.setEnabled(true);
//    officer.setActivationDate(LocalDateTime.of(2000,10,10,10,10));
//    return new ResponseEntity<>(officer, HttpStatus.OK);
//    }



@PostMapping("/officer")
public ResponseEntity<Officer> AddOfficer(@RequestBody Officer officer){
    if(officer != null) {
        officerService.createOfficer(officer);
        return new ResponseEntity<>(officer, HttpStatus.OK);
    }
    else  {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}


@GetMapping("/officer/{id}")
public ResponseEntity<Optional<Officer>> GetOfficer(@PathVariable long id){
    return new ResponseEntity<>(this.officerService.getOfficerById(id), HttpStatus.OK);

}



    @PostMapping("/poste")
    public ResponseEntity<MilitaryPost> savePoste(@RequestBody MilitaryPost poste){
        if (poste!=null){
            militaryPostRepo.save(poste);
        }
        return new ResponseEntity<MilitaryPost>(poste, HttpStatus.OK);
    }


}
