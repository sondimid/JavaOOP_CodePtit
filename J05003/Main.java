import java.util.*;
import java.io.*;

public class Main {
    static class Student{
        private String name,lop,birth,id="B20DCCN0";
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
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Student[] list = new Student[n];
        for(int i=0;i<n;i++){
            list[i] = new Student(sc.nextLine(),sc.next(),sc.next(),sc.nextDouble());
            list[i].setId(i+1);
            sc.nextLine();
        }
        for(Student s: list){
            System.out.println(s);
        }
    }
}