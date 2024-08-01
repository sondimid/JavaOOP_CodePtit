public class PhanSo {
    private int tu,mau;

    public PhanSo(int tu, int mau) {
        this.tu = tu;
        this.mau = mau;
    }
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public void rutGon(){
        int tmp = gcd(tu,mau);
        tu/=tmp;
        mau/=tmp;
    }
    public void add (PhanSo A){
        int a=this.tu;
        int b=this.mau;
        int c=A.tu;
        int d=A.mau;
        this.tu=a*d+b*c;
        this.mau=b*d;
        this.rutGon();
    }
    public void getPhanSo(){
        System.out.println(tu+"/"+mau);
    }
}
