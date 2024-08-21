import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
    private String name, id = "SV";
    private double score;

    public Student(String name, double score1, double score2, double score3, int id) {
        String[] s = name.trim().toLowerCase().split("\\s+");
        this.name = "";
        for(int i = 0; i < s.length; i++){
            this.name += Character.toUpperCase(s[i].charAt(0)) + s[i].substring(1) + " ";
        }
        this.score = score1*0.25 + score2*0.35 + score3*0.4;
        if(id < 10) this.id +='0';
        this.id +=Integer.toString(id);
    }

    public String getStatus(){
        if(score >= 8) return "GIOI";
        else if(score >= 6.5) return "KHA";
        else if(score >= 5) return "TRUNG BINH";
        return "KEM";
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f %s", id, name, score, getStatus());
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.score, this.score);
    }

}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 1;i <= n; i++){
            sc.nextLine();
            list.add(new Student(sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), i));
        }
        Collections.sort(list);
        for(Student student : list) System.out.println(student);
    }
}