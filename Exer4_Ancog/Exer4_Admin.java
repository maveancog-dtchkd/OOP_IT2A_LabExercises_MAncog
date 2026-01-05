public class Admin extends User {

    public Admin(String name, String email) {
        super(name, email);
    }

    @Override
    public void accessSystem() {
        System.out.println("Admin " + name + " is managing users and system settings.");
    }
}
