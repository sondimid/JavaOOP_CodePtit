import java.util.Scanner;
class NV {
    private String name,gender,ns,dc,mst,nk,mnv="00001";

    public NV(String name, String gender, String ns, String dc, String mst, String nk) {
        this.name = name;
        this.gender = gender;
        this.ns = ns;
        this.dc = dc;
        this.mst = mst;
        this.nk = nk;
    }
    public void print(){
        System.out.println(mnv+" "+name+" "+gender+" "+ns+" "+dc+" "+mst+" "+nk);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NV a = new NV(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine());
        a.print();
    }
}