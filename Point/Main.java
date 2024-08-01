import java.util.Scanner;

public class Main {
    public static void main(String []arg){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            Point A = new Point(sc.nextDouble(),sc.nextDouble());
            Point B = new Point(sc.nextDouble(),sc.nextDouble());
            System.out.println(String.format("%.4f",A.distance(B)));
        }
    }
}