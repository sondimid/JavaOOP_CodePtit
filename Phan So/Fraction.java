public class Fraction {
    private long tu,mau;

    public Fraction(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }

    public long getTu() {
        return tu;
    }

    public void setTu(long tu) {
        this.tu = tu;
    }

    public long getMau() {
        return mau;
    }

    public void setMau(long mau) {
        this.mau = mau;
    }
    public static long gcd(long a,long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public void rutgon(){
        long gcd = gcd(this.tu,this.mau);
        this.tu=this.tu/gcd;
        this.mau=this.mau/gcd;
    }
    public void getFraction(){
        System.out.println(getTu()+"/"+getMau());
    }
}