package springjwt.controllers;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.SpecializationRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class PatientController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @GetMapping("admin/patients")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllPatients() {

        List<User> patients = userRepository.findAllByRoles(1).stream().filter(a->a.getRoles().size()==1).collect(Collectors.toList());

        return patients;
    }
//    @GetMapping("/user/makeAppointment")
//    //@PreAuthorize("hasRole('ADMIN')")
//    public List<Specialization> getAllSpecializations() {
//
//        List<Specialization> specializations = specializationRepository.findAll();
//
//        return specializations;
//    }


}
