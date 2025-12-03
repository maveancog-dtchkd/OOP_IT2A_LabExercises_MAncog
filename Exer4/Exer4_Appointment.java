public class Appointment {
    protected String patientName;
    protected String date;
    protected String status = "PENDING";

    public Appointment(String patientName, String date) {
        this.patientName = patientName;
        this.date = date;
    }

    // Polymorphic Method
    public void processAppointment() {
        System.out.println("Processing a general appointment...");
    }

    public void showDetails() {
        System.out.println("Appointment for: " + patientName);
        System.out.println("Date: " + date);
        System.out.println("Status: " + status);
    }

    //method overloading
    public void showDetails(boolean showStatusOnly) {
        if (showStatusOnly) {
            System.out.println("Status: " + status);
        } else {
            showDetails();
        }
    }
}
