public class ApprovedAppointment extends Appointment {

    public ApprovedAppointment(String patientName, String date) {
        super(patientName, date);
        this.status = "APPROVED";
    }
}
