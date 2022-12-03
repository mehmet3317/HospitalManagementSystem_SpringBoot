package springjwt.service;

import com.bezkoder.springjwt.models.Appointment;
import com.bezkoder.springjwt.repository.AppointmentRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void addAppointment(Appointment appointment) {
       List<Appointment> list = appointmentRepository.findAllByDoctorName(appointment.getDoctorName());
       List<Appointment > list1 = list.stream().filter(a->a.getDate().equals(appointment.getDate())).collect(Collectors.toList());
//       if(list1.size()>0){
//           System.err.println("Current appointment date was taken");
//       }else{
           appointmentRepository.save(appointment);
       //}

    }
}
