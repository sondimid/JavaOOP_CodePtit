import java.util.Scanner;
class Staff {
    private String id,name,position;
    private int salary,cnt;

    public Staff(String name, int salary, int cnt, String position) {
        this.id="NV01";
        this.name = name;
        this.salary = salary;
        this.cnt = cnt;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getCnt() {
        return cnt;
    }
    public void print(){
        int bonus;
        int salaryM = this.salary*this.cnt;
        if(this.cnt<22) bonus=0;
        else if(this.cnt<25) bonus = (int) (0.1*salaryM);
        else bonus = (int) (0.2 * salaryM);
        int phuCap = 0;
        if(this.position.charAt(0) == 'G') phuCap = 250000;
        if(this.position.charAt(0) == 'P') phuCap = 200000;
        if(this.position.charAt(0) == 'T') phuCap = 180000;
        if(this.position.charAt(0) == 'N') phuCap = 150000;
        int income = this.salary*this.cnt + bonus + phuCap;
        System.out.println(this.id+" "+this.name+" "+salaryM+" "+bonus+" "+phuCap+" "+income);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Staff a = new Staff(sc.nextLine(),sc.nextInt(),sc.nextInt(),sc.next());
        a.print();
    }
}
