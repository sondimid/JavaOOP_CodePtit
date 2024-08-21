import java.util.*;
import java.io.*;

class Student {
    private String name = "", lop, birth, id = "B20DCCN";
    private double gpa;

    public Student(String name, String lop, String birth, double gpa, int id) {
        String[] s = name.trim().toLowerCase().split("\\s+");
        for(int i = 0; i < s.length; i++) this.name += Character.toUpperCase(s[i].charAt(0)) + s[i].substring(1) + " ";
        this.lop = lop;
        StringBuilder sb = new StringBuilder(birth);
        if(sb.charAt(2) != '/') sb.insert(0, '0');
        if(sb.charAt(5) != '/') sb.insert(3, '0');
        this.birth = sb.toString();
        this.gpa = gpa;
        this.id += String.format("%03d", id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", id, name, lop, birth, gpa);
    }

}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            list.add(new Student(sc.nextLine(), sc.next(), sc.next(), sc.nextDouble(), i));
        }
        for(Student student : list) System.out.println(student);
    }
}