package springjwt.controllers;

import com.bezkoder.springjwt.models.Appointment;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.AppointmentRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.service.AppointmentService;
import com.bezkoder.springjwt.service.EmailSenderService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class AppointmentController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private EmailSenderService emailSenderService;

    @RequestMapping(value = "/user/makeAppointment/{id}/{doctorName}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addAppointment(@RequestBody String appointment, @PathVariable String doctorName, @PathVariable Long id,Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        List<Appointment> list = appointmentRepository.findAllByDoctorName(doctorName);
        //list.stream().filter(a->a.getDate()==appointment);
        List<Appointment> existList = list.stream().filter(a->a.getDate().equals(appointment)).collect(Collectors.toList());

        if(existList.size()<1) {
            Appointment appointment1 = new Appointment();
            appointment1.setConfirmed("pending");
            appointment1.setDate(appointment);
            appointment1.setDoctorName(doctorName);
            appointment1.setPatientName(principal.getName());
            appointmentService.addAppointment(appointment1);
            return ResponseEntity.ok(new MessageResponse("Appointment was saved successfully!"));
        }
        return ResponseEntity.ok(new MessageResponse("Appointment was taken try another date"));
    }
    @RequestMapping(value = "/admin/appointments", method = RequestMethod.POST)
   // @PreAuthorize("hasRole('ADMIN')")
    public void changeStatus(@RequestBody String appointment_id,Principal principal) throws MessagingException, IOException, DocumentException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int idk = Integer.valueOf(appointment_id);

        List<Appointment> list = appointmentRepository.findAllByDoctorName("doctorMehmet");
        Optional <Appointment> opt = appointmentRepository.findById(idk);
        Appointment appointment = opt.get();

        //if(appointment.getConfirmed()=="pending") {

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("Appointment.pdf"));
        String str = appointment.getDate();
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Hi, Here is your appointment information\n", font);
        document.add(chunk);
        document.add(new Paragraph("Date of appointment : "+ appointment.getDate(), font));

        Chunk chunk3 = new Chunk("Name of the Doctor :" + appointment.getDoctorName()+"\n", font);
        document.add(chunk3);

        Chunk chunk4 = new Chunk("Name of the Patient :" + appointment.getPatientName()+"\n", font);
        document.add(chunk4);

        document.close();

        appointment.setConfirmed("confirmed");
        appointmentService.addAppointment(appointment);

            emailSenderService.sendMailWithAttachment("pausanchezvidal@yandex.com", "This is email body.", "This email subject", "" +
                        "/Users/mehmet/Downloads/spring-boot-spring-security-jwt-authentication-master/Appointment.pdf");
       // }
    }
    @GetMapping("/admin/appointments")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Appointment> showAppointmentsByDoctor(Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        List<Appointment> appointments = appointmentRepository.findAllByDoctorName(auth.getName());
        return appointments;
    }
    @GetMapping("/user/appointments/{name}")
    public List<Appointment> showAppointmentsByUser(@PathVariable String name) {
        List<Appointment> appointments = appointmentRepository.findAllByPatientName(name);
        return appointments;
    }
}