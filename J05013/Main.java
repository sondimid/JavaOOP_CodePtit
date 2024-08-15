import java.util.*;
import java.io.*;

class Employee implements Comparable<Employee>{
    private String name,id = "TS";
    private double score1, score2;

    public Employee(String name, double score1, double score2,int id) {
        this.name = name;
        if(score1 > 10){
            score1 /= 10.0;
        }
        if(score2 > 10){
            score2 /= 10.0;
        }
        this.score1 = score1;
        this.score2 = score2;
        if(id < 10) this.id += '0';
        this.id += Integer.toString(id);
    }

    public double getAverage(){
        return (score1 + score2) * 0.5;
    }

    public String getStatus(){
        if(getAverage() < 5) return "TRUOT";
        else if(getAverage() < 8) return "CAN NHAC";
        else if(getAverage() < 9.5) return "DAT";
        return "XUAT SAC";
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f %s", id, name, getAverage(), getStatus());
    }

    @Override
    public int compareTo(Employee o) {
        return -Double.compare(this.getAverage(), o.getAverage());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Employee> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            list.add(new Employee(sc.nextLine(), sc.nextDouble(), sc.nextDouble(), i));
        }
        Collections.sort(list);
        for(Employee employee : list){
            System.out.println(employee);
        }
    }
}