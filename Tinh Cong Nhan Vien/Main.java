import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Staff a = new Staff(sc.nextLine(),sc.nextInt(),sc.nextInt(),sc.next());
        a.print();
    }
}
