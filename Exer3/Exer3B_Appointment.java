public class Appointment {
    protected String patientName;
    protected String date;
    protected String status;

    public Appointment(String patientName, String date) {
        this.patientName = patientName;
        this.date = date;
        this.status = "PENDING";
    }

    public void showDetails() {
        System.out.println("Appointment for: " + patientName);
        System.out.println("Date: " + date);
        System.out.println("Status: " + status);
    }
}
