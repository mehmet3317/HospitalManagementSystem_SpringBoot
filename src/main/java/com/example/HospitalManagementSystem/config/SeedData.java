package com.example.HospitalManagementSystem.config;

import com.example.HospitalManagementSystem.model.Patient;
import com.example.HospitalManagementSystem.repository.PatientRepository;
import com.example.HospitalManagementSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;

public class SeedData implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Override
    public void run(String... args) throws Exception {

//        Patient patient = new Patient();
//        patient.setFirstname("mehmet");
//        patient.setLastname("LastName");
//        patient.setEmail("mehmet@gmail.com");
//
//        patientService.save(patient);
//        patientRepository.save(patient);
//
//
        List<Patient> list = patientService.getAllPatients();
        System.out.println(list);
        System.out.println("asfa");

    }
}
