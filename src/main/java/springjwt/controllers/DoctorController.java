package springjwt.controllers;
import com.bezkoder.springjwt.models.Appointment;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.AppointmentRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class DoctorController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/doctors")
    @PreAuthorize("hasRole('USER')")
    public List<User> getAllDoctors() {
        List<User> doctors = userRepository.findAllByRoles(3);
        return doctors;
    }
    @GetMapping("/user/makeAppointment/{id}/{doctorName}")
    //@PreAuthorize("hasRole('USER')")
    public List<String> getDoctorCalender(@PathVariable Long id, @PathVariable String doctorName) {
        Optional<User> opt = userRepository.findByUsername(doctorName);
        List<Appointment> appointmentList = appointmentRepository.findAllByDoctorName(doctorName);
        List<String> dates = appointmentList.stream().map(Appointment::getDate).collect(Collectors.toList());
        List<String> dates1 =new ArrayList<>();
        List<String> dates2 =new ArrayList<>();

        for(int i=0; i<dates.size(); i++) {
            for (int j = 0; j < 5; j++) {
                String year = dates.get(i).substring(1, 5);
                dates1.add(year);
                String month = dates.get(i).substring(6, 8);
                dates1.add(month);
                String day = dates.get(i).substring(9, 11);
                dates1.add(day);
                String hour = dates.get(i).substring(12, 14);
                dates1.add(hour);
                String minute = dates.get(i).substring(15, 17);
                dates1.add(minute);
            }
        }
    return dates;
    }
    //@GetMapping("/user/doctors/specialization/{id}")
    @GetMapping("/user/makeAppointment/{id}")
    //@PreAuthorize("hasRole('USER')")
    public List<User> getAllDoctorsBySpecialization(@PathVariable int id) {
        List<User> doctors = userRepository.findAllBySpecializations(id);
        return doctors;
    }

}
