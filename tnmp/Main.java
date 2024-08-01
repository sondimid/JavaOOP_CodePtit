import java.util.*;
import java.io.*;


public class Main {
    public static void main(String []arg){
        Scanner sc = new Scanner(System.in);
        long a=sc.nextLong();
        long b=sc.nextLong();
        Fraction f = new Fraction(a,b);
        f.rutgon();
        f.getFraction();
    }
}