package cau11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class cau11 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        ArrayList<Student> students = new ArrayList<Student>();
        int n1 = sc1.nextInt();
        sc1.nextLine();
        for(int i = 0; i < n1; i++){
            students.add(new Student(sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine()));
        }
        Scanner sc2 = new Scanner(new File("DETAI.in"));
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        int n2 = sc2.nextInt();
        sc2.nextLine();
        for(int i = 0; i < n2; i++){
            teachers.add(new Teacher(i + 1,sc2.nextLine(), sc2.nextLine()));
        }
        Scanner sc3 = new Scanner(new File("HOIDONG.in"));
        TreeMap<String, List<Student>> map = new TreeMap<>();
        int n3 = sc3.nextInt();
        Collections.sort(students);
        for(int i = 0; i < n3; i++){
            String id = sc3.next();
            String idProject = sc3.next();
            String hoidong = sc3.next();
            Student student;
            for(Student s : students){
                if(s.getId().equals(id)){
                    for(Teacher t : teachers){
                        if(t.getId().equals(idProject)){
                            s.setTeacher(t);
                            if(!map.containsKey(hoidong)){
                                ArrayList<Student> list = new ArrayList<Student>();
                                list.add(s);
                                map.put(hoidong,list);
                            }
                            else{
                                map.get(hoidong).add(s);
                            }
                        }
                    }
                }
            }

        }
        for(String hoidong : map.keySet()){
            System.out.println("DANH SACH HOI DONG " + hoidong.charAt(2) +":");
            ArrayList<Student> list = new ArrayList<Student>();
            list.addAll(map.get(hoidong));
            Collections.sort(list);
            for(Student s : list){
                System.out.println(s);
            }
        }
    }

}
