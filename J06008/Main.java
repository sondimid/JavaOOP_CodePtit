import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
class Subject{
    private String id, name;
    private double time = 0;

    public Subject(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public String getId() {
        return id;
    }

    public void setTime(double time) {
        this.time += time;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, time);
    }
}
class Teacher{
    private String id, name;
    private ArrayList<Subject> list = new ArrayList<>();

    public Teacher(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public void setList(String id, double time, String subjectName) {
        boolean check = false;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId().equals(id)){
                this.list.get(i).setTime(time);
                check = true;
                break;
            }
        }
        if(!check){
            Subject subject1 = new Subject(id,subjectName);
            subject1.setTime(time);
            this.list.add(subject1);
        }
    }

    public String getId() {
        return id;
    }

    public void print(){
        double time = 0;
        System.out.println("Giang vien: " + name);
        for(Subject subject : list){
            System.out.println(subject);
            time += subject.getTime();
        }
        System.out.printf("Tong: %.2f", time);
        System.out.println();
    }

}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, String> map1 = new HashMap<>();
        for(int i = 1; i <= n; i++){
            String line = sc.nextLine();
            String[] s = line.trim().split("\\s+");
            String name = line.substring(s[0].length()+1);
            map1.put(s[0],name);
        }

        ArrayList<Teacher> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        n = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= n;i++){
            String line = sc.nextLine();
            String id = line.substring(0,4);
            String name = line.substring(5);
            list.add(new Teacher(id, name));
        }
        n = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            String[] s = sc.nextLine().trim().split("\\s+");
            for(int j = 0; j < list.size(); j++){
                if(list.get(j).getId().equals(s[0])){
                    list.get(j).setList(s[1], Double.parseDouble(s[2]), map1.get(s[1]));
                }
            }
        }
        String id = sc.next();
        for(Teacher teacher : list) {
            if(teacher.getId().equals(id)) teacher.print();
        }
    }
}