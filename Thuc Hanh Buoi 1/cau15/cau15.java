package cau15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cau15 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        Scanner sc2 = new Scanner(new File("GIANGVIEN.in"));
        Scanner sc3 = new Scanner(new File("GIOCHUAN.in"));
        List<MonHoc> list = new ArrayList<MonHoc>();
        int n = sc1.nextInt();
        for (int i = 0; i < n; i++) {
            String id = sc1.next();
            list.add(new MonHoc(id, sc1.nextLine()));
        }
        List<Teacher> teachers = new ArrayList<>();
        n = sc2.nextInt();
        for(int i = 0; i < n; i++){
            String id = sc2.next();
            teachers.add(new Teacher(id, sc2.nextLine()));
        }
        n = sc3.nextInt();
        for(int i = 0; i < n; i++){
            String idTeacher = sc3.next();
            String idMonHoc = sc3.next();
            double time = sc3.nextDouble();
            for(Teacher teacher : teachers){
                if(teacher.getId().equals(idTeacher)){
                    teacher.setTime(time);
                    break;
                }
            }
        }
        for(Teacher teacher : teachers){
            System.out.println(teacher);
        }
    }
}
