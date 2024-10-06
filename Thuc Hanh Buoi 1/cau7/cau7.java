package cau7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class cau7 {
    public static boolean check(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='.' || s.charAt(i)==',' || s.charAt(i) =='!' ||s.charAt(i) =='?' || s.charAt(i) == ':'){
                return false;
            }
        }
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))) return true;
        }
        return false;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        TreeSet<String> set = new TreeSet<>();
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split("\\s+");
            for(String val : s){
                if(check(val)) set.add(val);
            }
        }
        for(String s : set){
            System.out.println(s);
        }
    }
}
