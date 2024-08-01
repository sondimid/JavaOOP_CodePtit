import static java.lang.Math.sqrt;

public class Point {
    private double x,y;

    public Point() {
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point(Point A){
        this.x=A.x;
        this.y=A.y;
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
    public double distance(Point A,Point B){
        return Math.sqrt((A.x-B.x)*(A.x-B.x)+(A.y-B.y)*(A.y-B.y));
    }

}
