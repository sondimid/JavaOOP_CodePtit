import java.util.*;
class Point {

    private double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public double distance(Point A){
        return Math.sqrt((this.x-A.x)*(this.x-A.x)+(this.y-A.y)*(this.y-A.y));
    }

}

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
            if(a+b<=c || b+c<=a || c+a<=b) System.out.print("INVALID");
            else{
                double r = a*b*c/(Math.sqrt((a + b + c) * (a + b - c ) * (-a + b + c) * (a - b + c)));
                System.out.printf("%.3f",Math.PI*r*r);
                System.out.println();
            }
            System.out.println();
        }
    }
}
