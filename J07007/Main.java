import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) {
        try {
            Scanner sc = new Scanner(new File("VANBAN.in"));
            TreeSet<String> set = new TreeSet<>();
            while(sc.hasNext()){
                set.add(sc.next().toLowerCase());
            }
            for(String s : set){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}