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

    @Override
    public String toString() {
        return String.format("%s %s", group, nameTeacher);
    }

    @Override
    public int compareTo(Course o) {
        return this.group.compareTo(o.group);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Course> list = new ArrayList<>();
        HashMap<String, String > mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String nameCourse = sc.nextLine();
            String group = sc.next();
            sc.nextLine();
            String nameTeacher = sc.nextLine();
            list.add(new Course(id, nameCourse, group, nameTeacher));
            mp.put(id, nameCourse);
        }
        Collections.sort(list);
        int m = sc.nextInt();
        while(m-->0){
            String id = sc.next();
            System.out.println("Danh sach nhom lop mon " + mp.get(id) + ":");
            for(Course course : list){
                if(course.getId().equals(id)){
                    System.out.println(course);
                }
            }
        }
    }
}