import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) {
        try {
            Scanner sc = new Scanner(new File("DATA.in"));
            ArrayList<String> list = new ArrayList<>();
            while(sc.hasNext()){
                String s = sc.next();
                try{
                    int digit = Integer.parseInt(s);
                }catch (Exception e){
                    list.add(s);
                }
            }
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            for(String s : list) System.out.print(s + " ");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}