public class StudentTester {
    public static void main(String[] args) {
        
        Student student1 = new Student();

      
        student1.setName("Mave Ancog");
        student1.setCourse("Information Technology");
        student1.setAge(19);

   
        System.out.println("Student Name: " + student1.getName());
        System.out.println("Student Course: " + student1.getCourse());
        System.out.println("Student Age: " + student1.getAge());
    }
}
