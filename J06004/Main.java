import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
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
        return String.format("%s %s %s %s %s", id, name, phoneNum, group, getProjectName());
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
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
        Collections.sort(list);
        for(Student student : list){
            System.out.println(student);
        }
    }
}