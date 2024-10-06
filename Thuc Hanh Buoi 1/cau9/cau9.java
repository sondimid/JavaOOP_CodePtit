package cau9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class cau9 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("LUYENTAP.in"));
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<Student>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            list.add(new Student(sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);
        for(Student s : list) System.out.println(s);
    }
}
