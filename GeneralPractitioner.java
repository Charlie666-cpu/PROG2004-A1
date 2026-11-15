import java.util.List;

public class GeneralPractitioner extends Doctor {
    public GeneralPractitioner(String id, String name, List<String> availableDays) {
        super(id, name, availableDays);
    }

    @Override
    public String getSpecialtyDetails() {
        return "General Practitioner (GP)";
    }
}

 
