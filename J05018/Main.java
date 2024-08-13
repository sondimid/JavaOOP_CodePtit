import java.util.*;
import java.io.*;
class Student{
    private String name,id="HS",level;
    private double score;

    public Student(String name, String id, double score) {
        this.name = name;
        if(Integer.parseInt(id) < 10) this.id += '0';
        this.id += id;
        this.score = score;
        if(score >= 9) this.level = "XUAT SAC";
        else if(score >= 8) this.level = "GIOI";
        else if(score >= 7) this.level = "KHA";
        else if(score >= 5) this.level = "TB";
        else this.level = "YEU";
    }

    public double getScore() {
        return score;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f %s", this.id, this.name, this.score*10.f/10.f, this.level);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String name = sc.nextLine();
            double score1 = sc.nextDouble();
            double score2 = sc.nextDouble();
            double score3 = sc.nextDouble();
            double score4 = sc.nextDouble();
            double score5 = sc.nextDouble();
            double score6 = sc.nextDouble();
            double score7 = sc.nextDouble();
            double score8 = sc.nextDouble();
            double score9 = sc.nextDouble();
            double score10 = sc.nextDouble();
            double score = (score1+score2+score3+score4+score5+score6+score7+score8+score9+score10+score1+score2)/12.0;
            list.add(new Student(name, Integer.toString(i), score));
            sc.nextLine();
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getScore() == o2.getScore()) {
                    return o1.getId().compareTo(o2.getId());
                }
                else{
                    if(o1.getScore() > o2.getScore()) return -1;
                    return 1;
                }
            }
        });
        for(Student student : list){
            System.out.println(student);
        }
    }
}