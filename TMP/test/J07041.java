package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class J07041 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static boolean check(int first, int second, HashMap<Integer, Integer> map) {
        if(map.containsKey(first) && map.get(first) == second)  return false;
        return true;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream file = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Pair> list = (ArrayList<Pair>) file.readObject();
        HashMap<Integer, Integer> map = new HashMap<>();
        Collections.sort(list);
        for(Pair pair : list) {
            if(check(pair.getFirst(), pair.getSecond(), map) && pair.getFirst() < pair.getSecond() && gcd(pair.getFirst(), pair.getSecond()) == 1) {
                map.put(pair.getFirst(), pair.getSecond());
                System.out.println(pair);
            }
        }
    }
}
