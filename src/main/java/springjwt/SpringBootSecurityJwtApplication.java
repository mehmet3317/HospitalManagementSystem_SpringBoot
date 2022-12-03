package springjwt;

import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.repository.AppointmentRepository;
import com.bezkoder.springjwt.repository.SpecializationRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityJwtApplication implements CommandLineRunner {
    @Autowired
	private UserRepository userRepository;

	@Autowired
	private AppointmentService appointmentService;
    @Autowired
	private SpecializationRepository specializationRepository;
	@Autowired
	private AppointmentRepository appointmentRepository;

	public static void main(String[] args) {
    SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user = new User("mehmet","mehmet@gmail.com","123");
//		userRepository.delete(user);
		//List<User> patients = userRepository.findAll().stream().filter(a ->a.getRoles().contains("ROLE_USER")).collect(Collectors.toList());

//		Optional<User> user = userRepository.findByUsername("mehmet");
//		User user1= user.get();
		//System.out.println(patients);
		//User user = new User("","mehmet@gmail.com","123");

//
//		Appointment appointment = new Appointment(2,"user","doctorMehmet","12.01.2022","cold","pending");
//		Appointment appointment = new Appointment(6,"patient1","doctorMehmet","12.01.2022","pending");
//		Appointment appointment = new Appointment(2,"patient2","Doctor","13.01.2022","pending");
//
//		Optional<User> user1 = userRepository.findByUsername("patient2");
//		User user= user1.get();
//		appointment.setUser(user);
		//appointmentService.addAppointment(appointment);

//		Optional<User> opt= userRepository.findByUsername("mehmet");
//		User user = opt.get();

		//List<User> users = userRepository.findAllBySpecializations(3);


		String name = "asd";

		//List<Appointment> list =appointments.stream().filter(a->a.getPatientName()=="asd").collect(Collectors.toList());
//		System.out.println(users.get(0).getUsername());
//
//		List<Specialization> specializations = specializationRepository.findAll();
//
//		System.out.println(specializations);


//		Appointment appointment = new Appointment(9,"patient1","doctorMehmet","15.01.2022","pending");
//
//		appointmentService.addAppointment(appointment);

//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		System.out.println(auth.getPrincipal());
//		List<Appointment> appointmentList = appointmentRepository.findAllByDoctorName("Doctor");
//		List<String> dates = appointmentList.stream().map(Appointment::getDate).collect(Collectors.toList());
//
//		System.out.println(dates);

	}
}
