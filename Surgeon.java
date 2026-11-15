import java.util.List;

public class Surgeon extends Doctor {
    public Surgeon(String id, String name, List<String> availableDays) {
        super(id, name, availableDays);
    }

    @Override
    public String getSpecialtyDetails() {
        return "Surgeon";
    }
}



