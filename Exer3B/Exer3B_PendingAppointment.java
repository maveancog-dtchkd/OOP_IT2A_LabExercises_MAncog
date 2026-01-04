public class PendingAppointment extends Appointment {

    public PendingAppointment(String patientName, String date) {
        super(patientName, date);
        this.status = "PENDING";
    }
}
