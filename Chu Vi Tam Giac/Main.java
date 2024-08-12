
import java.util.Scanner;
class Point {
    private double x,y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public double distance(Point A){
        return Math.sqrt((this.x-A.x)*(this.x-A.x)+(this.y-A.y)*(this.y-A.y));
    }
}

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
