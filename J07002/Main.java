import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) {
        try {
            Scanner sc = new Scanner(new File("DATA.in"));
            long ans = 0;
            while(sc.hasNext()){
                String s = sc.next();
                boolean check = true;
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) < '0' || s.charAt(i) > '9') check = false;
                }
                if(s.length() < 10 && check == true ) ans += Integer.parseInt(s);
            }
            System.out.println(ans);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}