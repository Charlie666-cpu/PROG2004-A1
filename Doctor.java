import java.util.List;

/**
 * Abstract class representing medical doctors who can prescribe medication.
 */
public abstract class Doctor extends HealthProfessional {
    public Doctor(String id, String name, List<String> availableDays) {
        super(id, name, availableDays);
    }
    
    public Doctor(String id, String name) {
        super(id, name);
    }

    // Common behavior for all doctors
    public void prescribeMedication(String medication) {
        System.out.println(getName() + " prescribed: " + medication);
    }
}


