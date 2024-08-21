import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
    private String name, scholarship;
    private double gpa;
    private int numOrder, trainingScore;

    public Student(String name, double gpa, int trainingScore,int numOrder) {
        this.name = name;
        this.gpa = gpa;
        this.trainingScore = trainingScore;
        this.numOrder = numOrder;
    }
    public void setScholarship(double minGpa){
        if(gpa >= minGpa){
            if(gpa >= 3.6 && trainingScore >= 90) this.scholarship = "XUATSAC";
            else if(gpa >= 3.2 && trainingScore >= 80) this.scholarship = "GIOI";
            else if(gpa >= 2.5 && trainingScore >= 70) this.scholarship = "KHA";
            else this.scholarship = "KHONG";
        }
        else this.scholarship = "KHONG";
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, scholarship);
    }

    public int getNumOrder() {
        return numOrder;
    }

    @Override
    public int compareTo(Student o) {
        return -Double.compare(this.gpa, o.gpa);
    }

    public double getGpa() {
        return gpa;
    }

    public String getName() {
        return name;
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int slot = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            sc.nextLine();
            list.add(new Student(sc.nextLine(), sc.nextDouble(), sc.nextInt(),i));
        }
        double minGpa = 0;
        Collections.sort(list);
        for(int i = 0; i < n; i++){
            list.get(i).setScholarship(slot);
            slot --;
            if(slot == 0) minGpa = list.get(i).getGpa();
        }
        for(int i = 0; i < n; i++){
            list.get(i).setScholarship(slot);
            slot --;
            if(slot == 0) minGpa = list.get(i).getGpa();
        }
        for(int i = 0; i < n; i++){
            list.get(i).setScholarship(minGpa);
        }
        for(int i = 1; i <= n; i++){
            for(Student student : list){
                if(student.getNumOrder() == i){
                    System.out.println(student);
                    break;
                }
            }
        }

    }
}