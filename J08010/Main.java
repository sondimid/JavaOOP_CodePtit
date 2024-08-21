import java.util.*;
import java.io.*;

public class Main {
    public static boolean check(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        while(sc.hasNext()){
            String s = sc.next();
            if(map.containsKey(s)) map.replace(s, map.get(s) + 1);
            else map.put(s, 1);
        }
        int sz = -1;
        for(String key : map.keySet()){
            if(check(key) && key.length() > sz) {
                sz = key.length();
            }
        }
        for(String key: map.keySet()){
            if(check(key) && key.length() == sz) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }
}