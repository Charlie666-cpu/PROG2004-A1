import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignmentOne {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Part 3 - Working with Professionals");
        System.out.println("=========================================");

        // 1. Create health professionals
        Doctor gp1 = new GeneralPractitioner("101", "Dr. Alice Smith", Arrays.asList("Mon", "Wed", "Fri"));
        Doctor gp2 = new GeneralPractitioner("102", "Dr. Bob Jones", Arrays.asList("Tue", "Thu"));
        Doctor surgeon1 = new Surgeon("201", "Dr. Diana Prince", Arrays.asList("Mon", "Thu"));
        
        HealthProfessional nurse1 = new Nurse("301", "Nurse Joy", Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri"));
        HealthProfessional dietitian1 = new Dietitian("401", "Ms. Emily Clark"); // Uses default days constructor

        // Polymorphism: Storing mixed types in a List
        List<HealthProfessional> professionals = new ArrayList<>();
        professionals.add(gp1);
        professionals.add(gp2);
        professionals.add(surgeon1);
        professionals.add(nurse1);
        professionals.add(dietitian1);

        // Displaying details
        for (HealthProfessional hp : professionals) {
            System.out.println(hp.toString());
        }

        // Testing specific behaviors
        System.out.println("\n--- Testing Specific Behaviors ---");
        gp1.prescribeMedication("Amoxicillin"); // Doctor behavior
        surgeon1.prescribeMedication("Painkillers"); // Doctor behavior
        ((Nurse) nurse1).takeBloodSample(); // Casting to access specific behavior
        ((Dietitian) dietitian1).createMealPlan(); // Casting to access specific behavior

        System.out.println("\n=========================================");
        System.out.println("   Part 4, 5, 6 - Appointment System");
        System.out.println("=========================================");

        AppointmentManager manager = new AppointmentManager();
        Patient p1 = new Patient("John Doe", "0412345678");
        Patient p2 = new Patient("Jane Roe", "0487654321");

        System.out.println("\n--- Adding Appointments ---");
        Appointment app1 = new Appointment(p1, gp1, LocalTime.of(9, 0));
        Appointment app2 = new Appointment(p2, surgeon1, LocalTime.of(10, 30));
        Appointment app3 = new Appointment(p1, nurse1, LocalTime.of(9, 0)); 
        Appointment app4 = new Appointment(p2, gp2, LocalTime.of(14, 0));

        System.out.println(manager.addAppointment(app1)); 
        System.out.println(manager.addAppointment(app2)); 
        System.out.println(manager.addAppointment(app3)); 
        System.out.println(manager.addAppointment(app4)); 

        System.out.println("\n--- Testing Error Cases (Adding) ---");
        Appointment doubleBook = new Appointment(p2, gp1, LocalTime.of(9, 0)); 
        System.out.println(manager.addAppointment(doubleBook)); 

        Appointment invalidTime = new Appointment(p1, gp1, LocalTime.of(17, 0)); 
        System.out.println(manager.addAppointment(invalidTime)); 

        System.out.println("\n--- Displaying All Appointments (Sorted) ---");
        manager.displayAllAppointments();

        System.out.println("\n--- Filtering Appointments ---");
        System.out.println("Appointments for GP1 (ID: 101):");
        List<Appointment> gp1Apps = manager.filterByProfessionalId("101");
        for (Appointment a : gp1Apps) System.out.println("  " + a);

        System.out.println("Appointments for Patient Phone 0412345678:");
        List<Appointment> patientApps = manager.filterByPatientPhone("0412345678");
        for (Appointment a : patientApps) System.out.println("  " + a);

        System.out.println("\n--- Cancelling Appointments ---");
        System.out.println(manager.cancelAppointmentByProfessionalAndTime("201", LocalTime.of(10, 30)));
        System.out.println(manager.cancelAppointmentByPatientPhone("0999999999"));

        System.out.println("\n--- Displaying Appointments After Cancellation ---");
        manager.displayAllAppointments();
    }
}


