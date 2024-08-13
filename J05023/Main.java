import java.util.*;
import java.io.*;
import java.util.*;
import java.io.*;
class Student{
    private String id,name,lop,email;

    public Student(String id, String name, String lop, String email) {
        this.id = id;
        this.name = name;
        this.lop = lop;
        this.email = email;
    }

    public String getLop() {
        return lop;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", this.id, this.name, this.lop, this.email);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String lop = sc.next();
            String email = sc.next();
            list.add(new Student(id, name, lop, email));
        }
        int q = sc.nextInt();
        while(q-->0){
            String tmp = sc.next();
            System.out.println("DANH SACH SINH VIEN KHOA "+tmp+":");
            for(Student student : list){
                if(student.getLop().charAt(1) == tmp.charAt(2) && student.getLop().charAt(2) == tmp.charAt(3)){
                    System.out.println(student);
                }
            }
        }
    }
}