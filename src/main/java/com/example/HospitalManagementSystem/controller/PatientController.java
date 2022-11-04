package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.model.Patient;
import com.example.HospitalManagementSystem.repository.PatientRepository;
import com.example.HospitalManagementSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

//    @GetMapping("") //Mapped for HTML page..
//    public String home() {
//        return "home";
//    }
    @CrossOrigin
    @GetMapping()
    public List<Patient> getAll(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        return patientRepository.findAll();
    }

    @GetMapping("/patientregistration")
    public String patient1(Model model) {
        model.addAttribute("patient", new Patient());
        return "patientregistration";
    }

//    @PostMapping("/patientlogin")
//    public String patientRegister(Patient patient) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(patient.getPassword());
//        patient.setPassword(encodedPassword);
//        patientRepository.save(patient);
//        return "patientlogin";
//    }

    @GetMapping("/patientlogin")
    public String patient2() {
        return "patientlogin";
    }

    @GetMapping("/patienthome")
    public String patientHome() {
        return "patienthome";
    }

}