import java.util.Scanner;
class Fraction {
    private long tu,mau;
    public Fraction(long tu,long mau){
        this.tu=tu;
        this.mau=mau;
    }
    public long gcd(long a,long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public void rutGon(){
        long gcd = gcd(this.tu,this.mau);
        this.tu/=gcd;
        this.mau /= gcd;
    }
    public void add(Fraction A){
        long a=this.tu;
        long b=this.mau;
        long c=A.tu;
        long d=A.mau;
        this.tu=a*d+b*c;
        this.mau=b*d;
        rutGon();
    }
    public void print(){
        System.out.println(this.tu +"/"+this.mau);
    }
}

public class Main {
    public static void main(String []arg){
        Scanner sc = new Scanner(System.in);
        Fraction a = new Fraction(sc.nextLong(), sc.nextLong());
        Fraction b = new Fraction(sc.nextLong(), sc.nextLong());
        a.add(b);
        a.print();
    }
}
