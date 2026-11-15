
public class Dietitian extends HealthProfessional {
    public Dietitian(String id, String name) {
        super(id, name); // Uses the overloaded default constructor
    }

    @Override
    public String getSpecialtyDetails() {
        return "Dietitian";
    }

    // Specific behavior for dietitians
    public void createMealPlan() {
        System.out.println("Dietitian " + getName() + " is creating a meal plan.");
    }
}






