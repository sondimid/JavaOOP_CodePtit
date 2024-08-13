import java.util.*;
import java.io.*;
class Student{
    private String name,lop,birth,id="B20DCCN0";
    private double gpa;

    public Student(String name, String lop, String birth, double gpa) {
        StringBuilder sb = new StringBuilder(birth);
        if(sb.charAt(2) != '/') sb.insert(0,'0');
        if(sb.charAt(5) != '/') sb.insert(3,'0');
        this.birth = sb.toString();
        this.name = "";
        String[] s = name.toLowerCase().trim().split("\\s+");;
        for(int i=0;i<s.length;i++){
            sb = new StringBuilder(s[i]);
            sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
            this.name += sb.toString();
            if(i != s.length-1){
                this.name +=" ";
            }
        }
        this.lop = lop;
        this.gpa = gpa;
    }

    public void setId(int id) {
        if(id < 10){
            this.id+='0'+Integer.toString(id);
        }
        else {
            this.id += Integer.toString(id);
        }
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f",this.id,this.name,this.lop,this.birth,this.gpa);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //sc.nextLine();
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            Student s = new Student(sc.nextLine(),sc.next(),sc.next(),sc.nextDouble());
            s.setId(i + 1);
            list.add(s);
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getGpa() < o2.getGpa()) return 1;
                return -1;
            }
        });
        for (Student s : list) {
            System.out.println(s);
        }
    }
}