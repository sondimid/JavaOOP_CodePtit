import java.util.Scanner;

public class Main {
    public static void main(String []arg){
        Scanner sc = new Scanner(System.in);
        SV a = new SV(sc.nextLine(),sc.nextLine(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        a.print();
    }
}
