public class Patient extends User {

    public Patient(String name, String email) {
        super(name, email);
    }

    public void requestAppointment() {
        System.out.println(name + " is requesting an appointment.");
    }
}
