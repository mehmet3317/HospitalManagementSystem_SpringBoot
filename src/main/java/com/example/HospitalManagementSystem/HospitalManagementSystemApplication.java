package com.example.HospitalManagementSystem;

import com.example.HospitalManagementSystem.model.Patient;
import com.example.HospitalManagementSystem.repository.PatientRepository;
import com.example.HospitalManagementSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HospitalManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private PatientService patientService;

	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
//		Patient patient = new Patient();
//		patient.setFirstname("mehmet");
//		patient.setLastname("LastName");
//		patient.setEmail("mehmet@gmail.com");
//
//		patientService.save(patient);
//		patientRepository.save(patient);


		List<Patient> list = patientService.getAllPatients();
		System.out.println(list);
	}
}
