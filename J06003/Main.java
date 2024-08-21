import java.util.*;
import java.io.*;

class Student{
    private String id, name, phoneNum, group, projectName;

    public Student(String id, String name, String phoneNum, String group) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.group = group;
    }

    public Student() {
        this.id = "";
        this.name = "";
        this.phoneNum = "";
        this.group = "";
        this.projectName = "";
    }

    public String getGroup() {
        return group;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", id, name, phoneNum);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int m = sc.nextInt();
         ArrayList<Student> list = new ArrayList<>();
         for(int i = 0; i < n; i++){
             String id = sc.next();
             sc.nextLine();
             list.add(new Student(id, sc.nextLine(), sc.next(), sc.next()));
         }
         sc.nextLine();
         for(int i = 1; i <= m; i++){
             String name = sc.nextLine();
             for(int j = 0; j < list.size(); j++){
                 if(list.get(j).getGroup().equals(Integer.toString(i))){
                     list.get(j).setProjectName(name);
                 }
             }
         }
         int q = sc.nextInt();
         while(q-->0){
             String group = sc.next();
             System.out.println("DANH SACH NHOM " + group + ":");
             String projectName = "";
             for(Student student : list){
                 if(student.getGroup().equals(group)){
                     System.out.println(student);
                     projectName = student.getProjectName();
                 }
             }
             System.out.println("Bai tap dang ky: " + projectName);
         }
    }
}