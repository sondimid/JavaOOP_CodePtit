package J07040;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class J07040 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream file1 = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        ArrayList<String> list1 = (ArrayList<String>) file1.readObject();
        HashSet<String> set = new HashSet<>();
        for(String str : list1) {
            String[] split = str.trim().toLowerCase().split("\\s+");
            set.addAll(Arrays.asList(split));
        }
        HashSet<String> set1 = new HashSet<>();
        Scanner sc = new Scanner(new File("VANBAN.in"));
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] split = s.trim().toLowerCase().split("\\s+");
            for (String string : split) {
                if (set.contains(string) && !set1.contains(string)) {
                    set1.add(string);
                    System.out.println(string);
                }
            }
        }
    }
}
