
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppointmentManager {
    private List<Appointment> appointments;
    private List<LocalTime> validTimeSlots;

    public AppointmentManager() {
        appointments = new ArrayList<>();
        validTimeSlots = new ArrayList<>();
        generateTimeSlots();
    }

    private void generateTimeSlots() {
        LocalTime start = LocalTime.of(8, 0);
        LocalTime end = LocalTime.of(16, 0);
        while (start.isBefore(end)) {
            validTimeSlots.add(start);
            start = start.plusMinutes(30);
        }
    }

    public String addAppointment(Appointment newAppointment) {
        if (!validTimeSlots.contains(newAppointment.getTime())) {
            return "WARNING: Invalid time slot. Clinic runs 08:00-16:00 in 30-min intervals.";
        }

        for (Appointment app : appointments) {
            if (app.getProfessional().equals(newAppointment.getProfessional()) && 
                app.getTime().equals(newAppointment.getTime())) {
                return "WARNING: Double booking! " + newAppointment.getProfessional().getName() + 
                       " is already booked at " + newAppointment.getTime();
            }
        }

        appointments.add(newAppointment);
        return "SUCCESS: Appointment added for " + newAppointment.getPatient().getName();
    }

    public void displayAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }
        Collections.sort(appointments);
        for (Appointment app : appointments) {
            System.out.println(app);
        }
    }

    public List<Appointment> filterByProfessionalId(String id) {
        List<Appointment> filtered = new ArrayList<>();
        for (Appointment app : appointments) {
            if (app.getProfessional().getId().equals(id)) filtered.add(app);
        }
        return filtered;
    }

    public List<Appointment> filterByPatientPhone(String phone) {
        List<Appointment> filtered = new ArrayList<>();
        for (Appointment app : appointments) {
            if (app.getPatient().getPhoneNumber().equals(phone)) filtered.add(app);
        }
        return filtered;
    }

    public String cancelAppointmentByProfessionalAndTime(String hpId, LocalTime time) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment app = appointments.get(i);
            if (app.getProfessional().getId().equals(hpId) && app.getTime().equals(time)) {
                appointments.remove(i);
                return "SUCCESS: Appointment cancelled.";
            }
        }
        return "WARNING: Appointment not found for cancellation.";
    }

    public String cancelAppointmentByPatientPhone(String phone) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getPatient().getPhoneNumber().equals(phone)) {
                appointments.remove(i);
                return "SUCCESS: Appointment cancelled for patient with phone " + phone;
            }
        }
        return "WARNING: No appointment found for patient phone " + phone;
    }
}






