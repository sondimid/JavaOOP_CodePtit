import java.util.*;
import java.io.*;

class Teacher{
    private String id, name;
    private int salary,coefficient;

    public Teacher(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.coefficient = Integer.parseInt(id.substring(2));
        this.salary = salary;
    }

    public int getBonus(){
        String ma = this.id.substring(0,2);
        if(ma.equals("HT")){
            return 2000000;
        }
        if(ma.equals("HP")){
            return 900000;
        }
        return 500000;
    }
    public int getTotalSalary(){
        return coefficient * salary + getBonus();
    }
    @Override
    public String toString() {
        return String.format("%s %s %d %d %d", id, name, coefficient, getBonus(), getTotalSalary());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Teacher> list = new ArrayList<>();
        int cntHT = 0;
        int cntHP = 0;
        for(int i = 1; i <= n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int salary = sc.nextInt();
            if(id.substring(0,2).equals("HT") && cntHT != 1){
                list.add(new Teacher(id, name, salary));
                cntHT++;
            }
            if(id.substring(0,2).equals("HP") && cntHP != 2){
                list.add(new Teacher(id, name, salary));
                cntHP++;
            }
            if(id.substring(0,2).equals("GV")){
                list.add(new Teacher(id, name, salary));
            }
        }
        for(Teacher teacher : list){
            System.out.println(teacher);
        }
    }
}