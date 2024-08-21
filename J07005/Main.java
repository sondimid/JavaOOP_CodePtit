import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) {

        try {
            DataInputStream sc = new DataInputStream(new FileInputStream("DATA.IN"));
            HashMap<Integer, Integer> mp = new HashMap<>();
            for(int i = 0; i< 100000; i++){
                int n = sc.readInt();
                if(mp.containsKey(n)) mp.put(n, mp.get(n)+1);
                else mp.put(n, 1);
            }
            for(Integer key : mp.keySet()){
                System.out.println(key + " " +mp.get(key));
            }
        } catch (Exception e){

        }

    }
}