import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.text.DecimalFormat;
class Student implements Comparable<Student>{
    private double toan,ly,hoa,sum,ut;
    private String name,id,tt;
    public DecimalFormat df = new DecimalFormat();
    public Student(String id, String name, double toan, double ly, double hoa) {
        this.id = id;
        this.name = name;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        this.sum = toan*2 + ly + hoa;
        if(id.charAt(2) == '1') this.ut=0.5;
        else if(id.charAt(2) == '2') this.ut=1;
        else this.ut=2.5;
        if(this.sum+this.ut<24) this.tt = "TRUOT";
        else this.tt = "TRUNG TUYEN";

    }

    public double getToan() {
        return toan;
    }

    public double getLy() {
        return ly;
    }

    public double getHoa() {
        return hoa;
    }

    public double getSum() {
        return sum;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getTt() {
        return tt;
    }

    public double getUt() {
        return ut;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", id, name, df.format(ut), df.format(sum+ut), tt);
    }

    @Override
    public int compareTo(Student o) {
        if(this.sum + this.ut == o.sum + o.ut){
            return this.id.compareTo(o.id);
        }
        else if(this.sum + this.ut > o.sum + o.ut) return -1;
        return 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            double score1 = sc.nextDouble();
            double score2 = sc.nextDouble();
            double score3 = sc.nextDouble();
            list.add(new Student(id, name, score1, score2, score3));
        }
        Collections.sort(list);
        for(Student student : list){
            System.out.println(student);
        }
    }
}