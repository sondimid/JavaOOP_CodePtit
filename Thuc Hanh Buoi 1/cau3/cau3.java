package cau3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cau3 {
    public static boolean check(String s){
        try{
            long val = Long.parseLong(s);
            if(val > Integer.MAX_VALUE) return true;
            return false;
        }catch (Exception e){
            return false;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        long res = 0;
        while (sc.hasNextLine()) {
            String[] s=sc.nextLine().split("\\s+");
            for(String val : s){
                if(check(val)){
                    res += Long.parseLong(val);
                }
            }
        }
        System.out.println(res);
    }
}
