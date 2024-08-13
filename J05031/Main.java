import java.util.*;
import java.io.*;
class Student{
    private String id, name, lop;
    private double score1, score2, score3;
    private int numOrder;

    public Student(String id, String name, String lop, double score1, double score2, double score3,int numOrder) {
        this.id = id;
        this.name = name;
        this.lop = lop;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.numOrder = numOrder;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.1f %.1f %.1f", this.id, this.name, this.lop, this.score1, this.score2, this.score3);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String lop = sc.next();
            double score1 = sc.nextDouble();
            double score2 = sc.nextDouble();
            double score3 = sc.nextDouble();
            list.add(new Student(id, name, lop, score1, score2, score3, i));
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        int cnt = 1;
        for(Student student : list){
            System.out.println(Integer.toString(cnt) + " " + student);
            cnt++;
        }
    }
}