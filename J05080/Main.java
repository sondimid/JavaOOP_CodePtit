import java.util.*;
import java.io.*;

class Course implements Comparable<Course>{
    private String id, nameCourse, group, nameTeacher;

    public Course(String id, String nameCourse, String group, String nameTeacher) {
        this.id = id;
        this.nameCourse = nameCourse;
        this.group = group;
        this.nameTeacher = nameTeacher;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public String getId() {
        return id;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", id, nameCourse, group);
    }

    @Override
    public int compareTo(Course o) {
        if(this.id.equals(o.id)){
            return this.group.compareTo(o.group);
        }
        return this.id.compareTo(o.id);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Course> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String nameCourse = sc.nextLine();
            String group = sc.next();
            sc.nextLine();
            String nameTeacher = sc.nextLine();
            list.add(new Course(id, nameCourse, group, nameTeacher));
        }
        Collections.sort(list);
        int m = sc.nextInt();
        sc.nextLine();
        while(m-->0){
            String nameTeacher = sc.nextLine();
            System.out.println("Danh sach cho giang vien " + nameTeacher + ":");
            for(Course course : list){
                if(course.getNameTeacher().equals(nameTeacher)){
                    System.out.println(course);
                }
            }
        }
    }
}