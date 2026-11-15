import java.time.LocalTime;

public class Appointment implements Comparable<Appointment> {
    private Patient patient;
    private HealthProfessional professional;
    private LocalTime time;

    public Appointment(Patient patient, HealthProfessional professional, LocalTime time) {
        if (patient == null || professional == null || time == null) {
            throw new IllegalArgumentException("Appointment details cannot be incomplete.");
        }
        this.patient = patient;
        this.professional = professional;
        this.time = time;
    }

    public Patient getPatient() { return patient; }
    public HealthProfessional getProfessional() { return professional; }
    public LocalTime getTime() { return time; }

    @Override
    public String toString() {
        return "Time: " + time + " | Patient: " + patient + " | Professional: " + professional.getName() 
               + " (" + professional.getSpecialtyDetails() + ")";
    }

    @Override
    public int compareTo(Appointment other) {
        return this.time.compareTo(other.time);
    }
}













