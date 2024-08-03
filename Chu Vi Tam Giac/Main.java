import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String []arg){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            Point A = new Point(sc.nextDouble(),sc.nextDouble());
            Point B = new Point(sc.nextDouble(),sc.nextDouble());
            Point C = new Point(sc.nextDouble(),sc.nextDouble());
            double AB = A.distance(B);
            double AC = A.distance(C);
            double BC = B.distance(C);
            if(AB+AC<=BC || AB+BC<=AC ||AC+BC<=AB) System.out.println("INVALID");
            else{
                System.out.printf("%.3f",AB+AC+BC);
                System.out.println();
            }
        }
    }
}
