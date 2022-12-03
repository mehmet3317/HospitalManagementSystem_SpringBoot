package springjwt.repository;

import com.bezkoder.springjwt.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findAllByDoctorName(String names);

    List<Appointment> findAllByPatientName(String names);

    //List<Appointment> findByC




}
