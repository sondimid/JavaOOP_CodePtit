package cau4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class cau4 {
    public static long parse(String s){
        long res = 0;
        for(int i=0;i<s.length();i++){
            res = res * 2 + (s.charAt(i)-'0') ;
        }
        return res;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream file = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> list = (ArrayList<String>) file.readObject();
        for(String s : list){
            String val = "";
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i)=='1' || s.charAt(i)=='0'){
                    val += s.charAt(i) ;
                }
            }
            System.out.println(val + " " + parse(val));
        }
    }
}
