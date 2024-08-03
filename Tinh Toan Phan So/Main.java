import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            Fraction A = new Fraction(sc.nextInt(),sc.nextInt());
            Fraction B = new Fraction(sc.nextInt(),sc.nextInt());
            Fraction a = new Fraction(A.getTu(),A.getMau());
            Fraction b = new Fraction(B.getTu(),B.getMau());
            a.add(b);
            a.binhP();
            a.rutGon();
            Fraction C = a;
            System.out.print(C.getTu()+"/"+C.getMau()+" ");
            A.mul(B);
            C.mul(A);
            Fraction D = C;
            D.rutGon();
            System.out.println(D.getTu()+"/"+D.getMau());

        }
    }
}
