public class User {
    protected String name;
    protected String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //overridden in subclasses
    public void accessSystem() {
        System.out.println(name + " is accessing the system.");
    }

    //method overloading
    public void accessSystem(String time) {
        System.out.println(name + " accessed the system at: " + time);
    }
}
