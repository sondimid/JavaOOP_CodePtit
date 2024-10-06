package cau5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeSet;

public class cau5 {
    public static boolean check(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i ==0) return false;
        }
        return n >= 100;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream file = new ObjectInputStream(new FileInputStream("DAYSO.DAT"));
        ArrayList<Integer> list = (ArrayList<Integer>) file.readObject();
        TreeSet<Integer> set = new TreeSet<>(list);
        for(Integer val : set){
            if(check(val)) System.out.println(val);
        }
    }
}
