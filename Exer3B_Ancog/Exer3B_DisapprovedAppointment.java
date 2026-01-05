public class DisapprovedAppointment extends Appointment {

    public DisapprovedAppointment(String patientName, String date) {
        super(patientName, date);
        this.status = "DISAPPROVED";
    }
}
