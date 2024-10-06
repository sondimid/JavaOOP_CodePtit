package J07016;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class J07016 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream file1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream file2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> list1 = (ArrayList<Integer>) file1.readObject();
        ArrayList<Integer> list2 = (ArrayList<Integer>) file2.readObject();
        TreeSet<Integer> set1 = new TreeSet<>(list1);
        TreeSet<Integer> set2 = new TreeSet<>(list2);
        for(Integer value : set1) {
            if(set2.contains(value) && Utils.isPrime(value)) {
                System.out.println(value + " " + Collections.frequency(list1, value) +  " " + Collections.frequency(list2, value));
            }
        }
    }
}
