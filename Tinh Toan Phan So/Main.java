import java.util.Scanner;
class Fraction {
    private long tu,mau;

    public Fraction(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }

    public long gcd(long a, long b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }

    public void rutGon(){
        long gcd = gcd(this.tu,this.mau);
        this.tu/=gcd;
        this.mau/=gcd;
    }
    public void add(Fraction A){
        this.tu = this.tu*A.mau+this.mau*A.tu;
        this.mau *=A.mau;
    }
    public void mul(Fraction A){
        this.tu=this.tu*A.tu;
        this.mau=this.mau*A.mau;
    }
    public void binhP(){
        this.tu*=this.tu;
        this.mau*=this.mau;
    }

    public long getTu() {
        return tu;
    }

    public long getMau() {
        return mau;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while(t-->0){
            Fraction A = new Fraction(sc.nextLong(),sc.nextLong());
            Fraction B = new Fraction(sc.nextLong(),sc.nextLong());
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
