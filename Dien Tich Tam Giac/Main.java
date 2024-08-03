import java.util.Scanner;

public class Main {
    public static void main (String []arg){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            Point A = new Point(sc.nextDouble(),sc.nextDouble());
            Point B = new Point(sc.nextDouble(),sc.nextDouble());
            Point C = new Point(sc.nextDouble(),sc.nextDouble());
            double a = C.distance(B);
            double b = A.distance(C);
            double c = B.distance(A);
            if(a+b<=c || b+c<=a || c+a<=b) System.out.println("INVALID");
            else{
                System.out.printf("%.2f",0.25*Math.sqrt((a+b+c)*(a+b-c)*(a+c-b)*(b+c-a)));
                System.out.println();
            }
        }
    }
}
