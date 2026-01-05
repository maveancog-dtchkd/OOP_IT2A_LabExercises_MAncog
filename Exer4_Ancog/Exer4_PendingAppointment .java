public class PendingAppointment extends Appointment {

    public PendingAppointment(String patientName, String date) {
        super(patientName, date);
        this.status = "PENDING";
    }

    @Override
    public void processAppointment() {
        System.out.println("Appointment for " + patientName + " is still pending.");
    }
}
