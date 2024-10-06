package cau8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class cau8 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        ArrayList<Student> list = new ArrayList<Student>();
        while (sc.hasNextLine()){
            String id = sc.nextLine();
            String name = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            String phoneNum = sc.nextLine();
            list.add(new Student(id, name, lop, email, phoneNum));
        }
        Collections.sort(list);
        for(Student s : list) System.out.println(s);
    }
}
