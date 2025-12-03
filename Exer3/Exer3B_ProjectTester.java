public class ProjectTester {
    public static void main(String[] args) {

        // ------------------------------
        // USERS
        // ------------------------------
        Patient p = new Patient("Maria Cruz", "maria@email.com");
        Staff s = new Staff("Nurse Ana", "ana@clinic.com");
        Admin a = new Admin("Admin Leo", "leo@admin.com");

        System.out.println("=== USERS ===");
        p.showInfo();
        p.requestAppointment();
        System.out.println();

        s.showInfo();
        s.checkAppointments();
        System.out.println();

        a.showInfo();
        a.manageSystem();
        System.out.println();

        // ------------------------------
        // APPOINTMENTS
        // ------------------------------
        Appointment ap1 = new PendingAppointment("Maria Cruz", "2025-12-10 09:00");
        Appointment ap2 = new ApprovedAppointment("Juan Dela Cruz", "2025-12-10 10:00");
        Appointment ap3 = new DisapprovedAppointment("Pedro Santos", "2025-12-10 11:00");

        System.out.println("=== APPOINTMENTS ===");
        ap1.showDetails();
        System.out.println();

        ap2.showDetails();
        System.out.println();

        ap3.showDetails();
        System.out.println();
    }
}
