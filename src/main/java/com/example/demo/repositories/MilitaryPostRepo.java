package com.example.demo.repositories;

import com.example.demo.models.MilitaryPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MilitaryPostRepo extends JpaRepository<MilitaryPost, Integer> {


}
