import java.util.Arrays;
import java.util.List;

/**
 * Abstract base class representing a generic health professional.
 */
public abstract class HealthProfessional {
    private String id;
    private String name;
    private List<String> availableDays;

    // Primary constructor
    public HealthProfessional(String id, String name, List<String> availableDays) {
        if (id == null || !id.matches("\\d+")) {
            throw new IllegalArgumentException("ID must consist of numbers only.");
        }
        this.id = id;
        this.name = name;
        this.availableDays = availableDays;
    }

    // Overloaded constructor: Provides a sensible default if days are not supplied
    public HealthProfessional(String id, String name) {
        this(id, name, Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri"));
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<String> getAvailableDays() { return availableDays; }

    /**
     * Abstract method forcing every specific type to provide its own details.
     */
    public abstract String getSpecialtyDetails();

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Days: " + availableDays + 
               " | Specialty: " + getSpecialtyDetails();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HealthProfessional that = (HealthProfessional) obj;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}



