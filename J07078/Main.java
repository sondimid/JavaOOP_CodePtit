import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("STRING.in"));
        int t = sc.nextInt();
        while(t-->0){
            String s1 = sc.next();
            String s2 = sc.next();
            int i = 0;
            while(i < s1.length()){
                int idx = s1.indexOf(s2,i);
                if(idx != -1){
                    System.out.print(idx + 1 + " ");
                    i = idx + 1;
                }
                else break;
            }
            System.out.println();
        }
    }
}