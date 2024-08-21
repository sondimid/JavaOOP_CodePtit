import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

class Student implements Comparable<Student> {
    private String id, name, status;
    private double score, priority;
    private DecimalFormat df = new DecimalFormat();

    public Student(String id, String name, double score1, double score2, double score3) {
        this.id = id;
        this.score = score1 * 2 + score2 + score3;
        if (id.charAt(2) == '1') this.priority = 0.5;
        else if (id.charAt(2) == '2') this.priority = 1.0;
        else this.priority = 2.5;
        this.name = "";
        String[] s = name.trim().toLowerCase().split("\\s+");
        for(int i = 0; i < s.length; i++){
            this.name += Character.toUpperCase(s[i].charAt(0)) + s[i].substring(1) + " ";
        }
    }

    public void setStatus(double score) {
        if(this.getTotal() >= score) this.status = "TRUNG TUYEN";
        else this.status = "TRUOT";
    }

    public double getTotal() {
        return score + priority;
    }

    @Override
    public String toString() {
        return String.format("%s %s%s %s %s", id, name, df.format(priority), df.format(getTotal()), status);

    }


    @Override
    public int compareTo(Student o) {
        if (this.getTotal() == o.getTotal()) return this.id.compareTo(o.id);
        return -Double.compare(this.getTotal(), o.getTotal());
    }
}

public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            double sc1 = sc.nextDouble();
            double sc2 = sc.nextDouble();
            double sc3 = sc.nextDouble();
            list.add(new Student(id, name, sc1, sc2, sc3));
        }
        Collections.sort(list);

        int num = sc.nextInt();
        double score = list.get(num-1).getTotal();

        System.out.println(score);
        for(Student student : list){
            student.setStatus(score);
            System.out.println(student);
        }
    }
}