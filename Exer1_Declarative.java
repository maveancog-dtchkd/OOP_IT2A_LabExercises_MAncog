public class Declarative {
    public static boolean isEven(int number) {
        return number % 2 == 0;    //stated rule
    }

    public static void main(String[] args) {
        int num = 6;
        System.out.println(num + " is even? " + isEven(num));
    }
}
