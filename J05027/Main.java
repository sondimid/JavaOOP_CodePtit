import java.util.*;
import java.io.*;
class Teacher{
    private String name, id="GV", major;

    public Teacher(String name, String major, String id) {
        this.name = name;
        this.major = major;
        if(Integer.parseInt(id) < 10) this.id += "0";
        this.id += id;
        String[] s = this.major.split("\\s+");
        this.major="";
        for(int i = 0; i < s.length; i++){
            this.major += Character.toUpperCase(s[i].charAt(0));
        }
    }

    public String getName() {
       return name;
    }

    public String getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.id ,this.name, this.major);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Teacher> list = new ArrayList<>();
        for(int i = 1; i <= n ; i++){
            String name = sc.nextLine();
            String major = sc.nextLine();
            list.add(new Teacher(name,major,Integer.toString(i)));
        }
        int q = sc.nextInt();
        while(q-->0){
            String tmp = sc.next();
            String name = tmp.toUpperCase();
            System.out.println("DANH SACH GIANG VIEN THEO TU KHOA " + tmp + ":");
            for(Teacher teacher : list){
                if(teacher.getName().toUpperCase().contains(name)){
                    System.out.println(teacher);
                }
            }
        }
    }
}