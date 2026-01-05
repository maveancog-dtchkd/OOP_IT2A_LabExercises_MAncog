public class ApprovedAppointment extends Appointment {

    public ApprovedAppointment(String patientName, String date) {
        super(patientName, date);
        this.status = "APPROVED";
    }

    @Override
    public void processAppointment() {
        System.out.println("Appointment for " + patientName + " has been approved!");
    }
}
