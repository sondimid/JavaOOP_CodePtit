import java.io.*;
import java.util.*;
class Triangle {
    private double a,b,c,perimeter;

    public Triangle(Point A,Point B, Point C) {
        this.a = B.distance(C);
        this.b = A.distance(C);
        this.c = B.distance(A);
        this.perimeter = a+b+c;
    }
    public boolean valid(){
        if(this.a+this.b<=this.c || this.c+this.b <= this.a || this.a+this.c <=this.b) return false;
        return true;
    }

    public String getPerimeter() {
        return String.format("%.3f",this.perimeter);
    }
}

class Point {
    private double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point nextPoint(Scanner sc){
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        return new Point(x,y);
    }
    public double distance(Point A){
        return Math.sqrt((this.x-A.x)*(this.x-A.x)+(this.y-A.y)*(this.y-A.y));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }

}
