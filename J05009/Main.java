import java.util.*;
import java.io.*;
class Student{
    private String name,birth;
    private double score1,score2,score3;
    private int id;

    public Student(String name, String birth, double score1, double score2, double score3) {
        this.name = name;
        this.birth = birth;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public void setId(int id) {
        this.id = id;
    }
    public double getScore(){
        return this.score1 + this.score2 + this.score3;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.1f", Integer.toString(this.id), this.name, this.birth, getScore());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Student> list = new ArrayList<>();
        double maxScore = -1;
        for(int i = 1; i <= n; i++){
            String name = sc.nextLine();
            String birth = sc.next();
            double score1 = sc.nextDouble();
            double score2 = sc.nextDouble();
            double score3 = sc.nextDouble();
            sc.nextLine();
            Student s = new Student(name, birth, score1, score2, score3);
            s.setId(i);
            list.add(s);
            maxScore = Math.max(maxScore,s.getScore());
        }
        for(Student s: list){
            if(s.getScore() == maxScore){
                System.out.println(s);
            }
        }
    }
}