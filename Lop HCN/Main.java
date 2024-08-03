import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Rectange r = new Rectange(sc.nextInt(),sc.nextInt(),sc.next());
        if(r.getH()<=0 || r.getW()<=0 ){
            System.out.println("INVALID");
        }
        else{
            System.out.println(r.findPerimeter()+" "+r.findArea()+" "+r.getColor());
        }
    }
}