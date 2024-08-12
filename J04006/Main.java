import java.util.*;
import java.io.*;
class Student{
    private String name,lop,birth,id="B20DCCN001";
    private double gpa;

    public Student(String name, String lop, String birth, double gpa) {
        StringBuilder sb = new StringBuilder(birth);
        if(sb.charAt(2) != '/') sb.insert(0,'0');
        if(sb.charAt(5) != '/') sb.insert(3,'0');
        birth = sb.toString();
        this.name = name;
        this.lop = lop;
        this.birth = birth;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f",this.id, this.name, this.lop, this.birth, this.gpa);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        Student a = new Student(sc.nextLine(), sc.next(), sc.next(), sc.nextDouble());
        System.out.println(a);
    }
}