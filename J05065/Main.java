import java.util.*;
import java.io.*;

class Employee implements Comparable<Employee>{
    private String level, name, coefficient, id;

    public Employee(String code, String name) {
        this.name = name;
        this.coefficient = code.substring(2,4);
        this.id = code.substring(code.length()-3);
        this.level = code.substring(0,2);
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(int num){
        if(num <= 0) this.level = "NV";
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", name, level, id, coefficient);
    }

    @Override
    public int compareTo(Employee o) {
        if(this.coefficient.equals(o.coefficient)) return this.id.compareTo(o.id);
        return -this.coefficient.compareTo(o.coefficient);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int gd = 1, tp = 3, pp = 3;
        ArrayList<Employee> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String code = sc.next();
            String name = sc.nextLine();
            Employee employee = new Employee(code, name);
            if(employee.getLevel().equals("GD")){
                employee.setLevel(gd);
                gd --;
            }
            if(employee.getLevel().equals("TP")){
                employee.setLevel(tp);
                tp --;
            }
            if(employee.getLevel().equals("PP")){
                employee.setLevel(pp);
                pp --;
            }
            list.add(employee);
        }
        Collections.sort(list);
        int q = sc.nextInt();
        while(q-->0){
            String level = sc.next();
            for(Employee employee : list){
                if(employee.getLevel().equals(level)) System.out.println(employee);
            }
            System.out.println();
        }
    }
}