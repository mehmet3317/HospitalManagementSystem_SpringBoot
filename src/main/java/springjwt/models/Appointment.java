package springjwt.models;

import javax.persistence.*;

@Entity
public class Appointment {

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="appointment_id")
        private Integer appointment_id;

        @Column(name="patient_name")
        private String patientName;

        @Column(name="doctor_name")
        private String doctorName;

        @Column(name="appointment_date")
        private String date;

//        @Column(name="prescription")
//        private String prescription;

        @Column(name="confirmed")
        private String confirmed;

//        public String getPrescription() {
//            return prescription;
//        }
//
//        public void setPrescription(String prescription) {
//            this.prescription = prescription;
//        }


        @Override
        public String toString() {
            return "appointment [appointment_id=" + appointment_id + ", patientName=" + patientName + ", doctorName="
                    + doctorName + ", date=" + date +  "]";
        }

        public Appointment(Integer appointment_id, String patientName, String doctorName, String date,String confirmed) {
            super();
            this.appointment_id = appointment_id;
            this.patientName = patientName;
            this.doctorName = doctorName;
            this.date = date;
//            this.prescription = prescriptionion;
            this.confirmed=confirmed;
        }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Integer getAppointment_id() {
            return appointment_id;
        }

        public void setAppointment_id(Integer appointment_id) {
            this.appointment_id = appointment_id;
        }

        public Appointment() {}

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getConfirmed() {
            return confirmed;
        }

        public void setConfirmed(String confirmed) {
            this.confirmed = confirmed;
        }
}
