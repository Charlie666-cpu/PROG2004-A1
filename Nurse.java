import java.util.List;

public class Nurse extends HealthProfessional {
    public Nurse(String id, String name, List<String> availableDays) {
        super(id, name, availableDays);
    }

    @Override
    public String getSpecialtyDetails() {
        return "Nurse";
    }

    // Specific behavior for nurses
    public void takeBloodSample() {
        System.out.println("Nurse " + getName() + " is taking a blood sample.");
    }
}




