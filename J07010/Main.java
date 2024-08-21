import java.util.*;
import java.io.*;

class Student{
    private String name, id="B20DCCN0", lop, birth;
    private double gpa;

    public Student(String name, String lop, String birth, double gpa,int id) {
        if(id < 10) this.id += '0';
        this.id += Integer.toString(id);
        this.name = name;
        this.lop = lop;
        StringBuilder sb = new StringBuilder(birth);
        if(sb.charAt(2) != '/') sb.insert(0,'0');
        if(sb.charAt(5) != '/') sb.insert(3,'0');
        this.birth = sb.toString();
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", id, name, lop, birth, gpa);
    }
}
public class Main {
    public static void main(String[] arg) {
        try {
            Scanner sc = new Scanner(new File("SV.in"));
            ArrayList<Student> list = new ArrayList<>();
            int n = sc.nextInt();
            for(int i = 1; i <= n; i++){
                sc.nextLine();
                String name = sc.nextLine();
                String lop = sc.next();
                String birth = sc.next();
                double gpa = sc.nextDouble();
                list.add(new Student(name, lop, birth, gpa, i));
            }
            for(Student student : list){
                System.out.println(student);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}