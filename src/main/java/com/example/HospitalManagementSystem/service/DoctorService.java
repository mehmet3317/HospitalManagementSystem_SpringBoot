package com.example.HospitalManagementSystem.service;


import com.example.HospitalManagementSystem.model.Doctor;
import com.example.HospitalManagementSystem.model.Patient;
import com.example.HospitalManagementSystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    public List<Doctor> getAllDoctors(){

        return doctorRepository.findAll();
    }
    public Doctor save(Doctor doctor){
        return doctorRepository.save(doctor);
    }
}
