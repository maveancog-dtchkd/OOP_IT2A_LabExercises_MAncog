public class Admin extends User {

    public Admin(String name, String email) {
        super(name, email);
    }

    public void manageSystem() {
        System.out.println(name + " is managing system settings.");
    }
}
