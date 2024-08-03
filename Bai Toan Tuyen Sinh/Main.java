import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat();
        Student a = new Student(sc.nextLine(),sc.nextLine(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        System.out.println(a.getId()+" "+a.getName()+" "+df.format(a.getUt())+" "+df.format(a.getSum())+" "+a.getTt());
    }
}
