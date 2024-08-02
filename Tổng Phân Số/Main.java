import java.util.Scanner;

public class Main {
    public static void main(String []arg){
        Scanner sc = new Scanner(System.in);
        Fraction a = new Fraction(sc.nextInt(), sc.nextInt());
        Fraction b = new Fraction(sc.nextInt(),sc.nextInt());
        a.add(b);
        a.print();
    }
}
