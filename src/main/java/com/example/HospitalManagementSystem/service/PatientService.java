package com.example.HospitalManagementSystem.service;


import com.example.HospitalManagementSystem.model.Patient;
import com.example.HospitalManagementSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


    public List<Patient> getAllPatients(){

        return patientRepository.findAll();
    }
    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }
}
