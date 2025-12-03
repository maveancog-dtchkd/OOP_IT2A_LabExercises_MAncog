public class Patient extends User {

    public Patient(String name, String email) {
        super(name, email);
    }

    @Override
    public void accessSystem() {
        System.out.println("Patient " + name + " is booking appointments.");
    }
}
