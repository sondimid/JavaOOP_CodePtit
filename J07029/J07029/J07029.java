package J07029;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.KeyStore;
import java.util.*;

public class J07029 {
    public static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)  return false;
        }
        return n >= 2;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream file = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> list = (ArrayList<Integer>) file.readObject();
        List<Pair> result = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Integer i : list) {
            if(isPrime(i)) {
                map.put(i, map.getOrDefault(i,0) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(new Pair(entry.getKey(), entry.getValue()));
        }
        Collections.sort(result);
        for(int i = 0; i < 10; i++) {
            System.out.println(result.get(i));
        }
    }
}
