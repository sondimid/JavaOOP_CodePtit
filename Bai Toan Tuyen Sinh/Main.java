import java.util.Scanner;
import java.text.DecimalFormat;
class Student {
    private double toan,ly,hoa,sum,ut;
    private String name,id,tt;

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
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat();
        Student a = new Student(sc.nextLine(),sc.nextLine(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        System.out.println(a.getId()+" "+a.getName()+" "+df.format(a.getUt())+" "+df.format(a.getSum())+" "+a.getTt());
    }
}
