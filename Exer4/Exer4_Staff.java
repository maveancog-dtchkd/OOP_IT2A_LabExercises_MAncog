public class Staff extends User {

    public Staff(String name, String email) {
        super(name, email);
    }

    @Override
    public void accessSystem() {
        System.out.println("Staff " + name + " is viewing today's appointments.");
    }
}
