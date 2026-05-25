package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Officer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1000)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private int militaryNumber;
    private boolean  enabled;
    private LocalDateTime activationDate;
    @ManyToOne
    private MilitaryPost postId;


    public Officer(){  }

    public Officer(Long id, String firstName, String lastName, int militaryNumber, boolean enabled, LocalDateTime activationDate, MilitaryPost postId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.militaryNumber = militaryNumber;
        this.enabled = enabled;
        this.activationDate = activationDate;
        this.postId = postId;
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMilitaryNumber() {
        return militaryNumber;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public LocalDateTime getActivationDate() {
        return activationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMilitaryNumber(int militaryNumber) {
        this.militaryNumber = militaryNumber;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setActivationDate(LocalDateTime activationDate) {
        this.activationDate = activationDate;
    }
}
