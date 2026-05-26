package com.example.demo.repositories;

import com.example.demo.models.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepo extends JpaRepository<Officer, Long> {


}
