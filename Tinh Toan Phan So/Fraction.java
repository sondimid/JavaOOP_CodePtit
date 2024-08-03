public class Fraction {
    private int tu,mau;

    public Fraction(int tu, int mau) {
        this.tu = tu;
        this.mau = mau;
    }

    public int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }

    public void rutGon(){
        int gcd = gcd(this.tu,this.mau);
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

    public int getTu() {
        return tu;
    }

    public int getMau() {
        return mau;
    }
}
