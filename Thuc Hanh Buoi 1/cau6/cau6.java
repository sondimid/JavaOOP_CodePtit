package cau6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class cau6 {
    public static String format(String s){
        String[] res = s.trim().toLowerCase().split("\\s+");
        String ans = res[res.length-1];
        for(int i = 0; i < res.length-1; i++){
            ans += res[i].charAt(0);
        }
        return ans;
    }
    public static String getName(String s){
        String[] res = s.trim().toLowerCase().split("\\s+");
        String ans = "";
        for(int i = 0; i < res.length-1; i++){
            ans += res[i] + " ";
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> name = new HashMap<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String val = format(s);
            if(!name.containsKey(getName(s))){
                name.put(getName(s), 1);
                if(!map.containsKey(val)){
                    map.put(val, 1);
                    System.out.println(String.format("%s@ptit.edu.vn", val));
                }
                else{
                    map.put(val, map.get(val)+1);
                    System.out.println(String.format("%s%d@ptit.edu.vn", val, map.get(val)));
                }
            }
        }
    }
}
