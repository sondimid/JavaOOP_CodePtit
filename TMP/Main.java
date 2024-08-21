import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        HashMap<String, Integer> map = new HashMap<>();
        while(sc.hasNextLine()){
            String[] s = sc.nextLine().trim().split("\\s+");
            if(map.containsKey(s[1])){
                map.replace(s[1], map.get(s[1])+1);
            }
            else{
                map.put(s[1], 1);
            }
        }
        for(String key : map.keySet()){
            if(map.get(key) > 1) System.out.println(key);
        }
    }
}