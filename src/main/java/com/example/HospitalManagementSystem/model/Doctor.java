package com.example.HospitalManagementSystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor extends User{

    private String phoneNum;

    public Doctor() {
    }

    public Doctor(User user){
        this.setUsername(user.getUsername());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setRoles(user.getRoles());
    }

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

}