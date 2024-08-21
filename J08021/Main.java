import java.util.*;
import java.io.*;

public class Main {
    public static int longest(String s){
        int l = 0, r = 0;
        int len = 0;
        for(int i  = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') l ++;
            else r ++;
            if(r > l) r = l = 0;
            else if(l == r) len = Math.max(len, l*2);
        }
        l = r = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ')') r++;
            else l++;
            if(l > r) r = l = 0;
            else if(r == l) len = Math.max(len, l*2);
        }
        return len;
    }
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            System.out.println(longest(s));
        }
    }
}