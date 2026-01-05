public class Staff extends User {

    public Staff(String name, String email) {
        super(name, email);
    }

    public void checkAppointments() {
        System.out.println(name + " is checking today's appointments.");
    }
}
