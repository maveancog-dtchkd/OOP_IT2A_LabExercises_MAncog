public class DisapprovedAppointment extends Appointment {

    public DisapprovedAppointment(String patientName, String date) {
        super(patientName, date);
        this.status = "DISAPPROVED";
    }

    @Override
    public void processAppointment() {
        System.out.println("Appointment for " + patientName + " has been rejected.");
    }
}
