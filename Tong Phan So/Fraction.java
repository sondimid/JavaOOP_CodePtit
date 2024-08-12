//public class Fraction {
//    private int tu,mau;
//    public Fraction(int tu,int mau){
//        this.tu=tu;
//        this.mau=mau;
//    }
//    public int gcd(int a,int b) {
//        if (b == 0) return a;
//        return gcd(b, a % b);
//    }
//    public void rutGon(){
//        int gcd = gcd(this.tu,this.mau);
//        this.tu/=gcd;
//        this.mau /= gcd;
//    }
//    public void add(Fraction A){
//        int a=this.tu;
//        int b=this.mau;
//        int c=A.tu;
//        int d=A.mau;
//        this.tu=a*d+b*c;
//        this.mau=b*d;
//        rutGon();
//    }
//    public void print(){
//        System.out.println(this.tu +"/"+this.mau);
//    }
//}
