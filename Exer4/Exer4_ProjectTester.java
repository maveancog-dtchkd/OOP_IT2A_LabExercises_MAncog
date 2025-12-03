public class ProjectTester {
    public static void main(String[] args) {

        System.out.println("========== POLYMORPHISM: USERS ==========\n");

        // Polymorphic array (Parent type → Child objects)
        User[] users = {
                new Patient("Mang Kepwing", "mang@email.com"),
                new Staff("Nurse Ana", "ana@clinic.com"),
                new Admin("Sir Leo", "leo@admin.com")
        };

        for (User u : users) {
            u.accessSystem();  // <-- POLYMORPHISM
            u.accessSystem("10:30 AM"); // <-- METHOD OVERLOADING
            System.out.println();
        }

        System.out.println("========== POLYMORPHISM: APPOINTMENTS ==========\n");

        Appointment[] appts = {
                new PendingAppointment("Mang Kepwing", "2023-12-07 06:00"),
                new ApprovedAppointment("Hala si Oa", "2023-11-08 05:00"),
                new DisapprovedAppointment("Pedro Santisima", "2023-10-09 04:00")
        };

        for (Appointment ap : appts) {
            ap.processAppointment();  // <-- POLYMORPHISM
            ap.showDetails();       
            ap.showDetails(true);     // <-- METHOD OVERLOADING
            System.out.println();
        }
    }
}
