package com.example.HospitalManagementSystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor extends User{
    @ManyToMany(mappedBy = "doctors")
    private List<Patient> patients;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

}