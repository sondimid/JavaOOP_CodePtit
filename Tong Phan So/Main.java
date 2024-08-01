
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] arg){
        Scanner sc =new Scanner(System.in);
        int a,b,c,d;
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        d=sc.nextInt();
        PhanSo A = new PhanSo(a,b);
        PhanSo B = new PhanSo(c,d);
        A.add(B);
        A.rutGon();
        A.getPhanSo();
    }
}
