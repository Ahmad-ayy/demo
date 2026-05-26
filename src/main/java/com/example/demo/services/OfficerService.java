package com.example.demo.services;

import com.example.demo.models.Officer;
import com.example.demo.repositories.OfficerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfficerService {

    @Autowired
    private final OfficerRepo officerRepo;
    public OfficerService(OfficerRepo officerRepo) {
        this.officerRepo = officerRepo;
    }

    public Officer createOfficer(Officer officer){
        return officerRepo.save(officer);
    }

    public Optional<Officer> getOfficerById(long id){
        return  this.officerRepo.findById(id);

    }

}
