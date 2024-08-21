import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
    private String name = "", nation, id = "TS";
    private double score;
    private int area;

    public Student(String name, double score, String nation, int area, int id) {
        String[] s = name.trim().toLowerCase().split("\\s+");
        for(int i = 0; i < s.length; i++){
            this.name += Character.toUpperCase(s[i].charAt(0)) + s[i].substring(1) + " ";
        }
        this.score = score;
        this.nation = nation;
        this.area = area;
        if(id < 10) this.id += '0';
        this.id += Integer.toString(id);
    }

    public double getScore() {
        double score = this.score;
        if(area == 1) score += 1.5;
        if(area == 2) score += 1;
        if(!nation.equals("Kinh")) score += 1.5;
        return score;
    }

    public String getStatus(){
        if(getScore() >= 20.5) return "Do";
        return "Truot";
    }
    @Override
    public String toString() {
        return String.format("%s %s %.1f %s", id, name, getScore(), getStatus());
    }

    @Override
    public int compareTo(Student o) {
        if(this.getScore() == o.getScore()) return this.id.compareTo(o.id);
        return Double.compare(o.getScore(), this.getScore());
    }
}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 1;i <= n; i++){
            sc.nextLine();
            String name = sc.nextLine();
            double score = sc.nextDouble();
            sc.nextLine();
            String nation = sc.nextLine();
            int area = sc.nextInt();
            list.add(new Student(name, score, nation, area, i));
        }
        Collections.sort(list);
        for(Student student : list) System.out.println(student);
    }
}