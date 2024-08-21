import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) {
        try {
            Scanner sc = new Scanner(new File("DATA.in"));
            while(true){
                String name = sc.nextLine();
                if(name.equals("END")) break;
                String[] s = name.trim().toLowerCase().split("\\s+");
                name = "";
                for(int i = 0; i < s.length; i++){
                    StringBuilder sb = new StringBuilder(s[i]);
                    sb.setCharAt(0, Character.toUpperCase(s[i].charAt(0)));
                    name += sb.toString() + " ";
                }
                System.out.println(name);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}