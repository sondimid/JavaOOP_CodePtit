import java.util.Scanner;
class SV {
    private String name;
    private String dob;
    private double diem1,diem2,diem3;

    public SV(String name, String dob, double diem1, double diem2, double diem3) {
        this.name = name;
        this.dob = dob;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }
    public void print(){
        double diem=diem1+diem2+diem3;
        System.out.print(name +" "+dob+" ");
        System.out.printf("%.1f",diem);
    }
}

public class Main {
    public static void main(String []arg){
        Scanner sc = new Scanner(System.in);
        SV a = new SV(sc.nextLine(),sc.next(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        a.print();
    }
}
