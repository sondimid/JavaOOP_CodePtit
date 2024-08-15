import java.util.*;
import java.io.*;

class Employee{
    private String id, name, department;
    private int unitSalary, numWork;

    public Employee(String id, String name, int unitSalary, int numWork) {
        this.id = id;
        this.name = name;
        this.unitSalary = unitSalary;
        this.numWork = numWork;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public int getTotalSalary(){
        char employeeType = id.charAt(0);
        int year = Integer.parseInt(id.substring(1,3));
        int coefficient = 0;

        if(employeeType == 'A'){
            if(year <= 3) coefficient = 10;
            else if(year <= 8) coefficient = 12;
            else if(year <= 15) coefficient = 14;
            else coefficient = 20;
        }

        if(employeeType == 'B'){
            if(year <= 3) coefficient = 10;
            else if(year <= 8) coefficient = 11;
            else if(year <= 15) coefficient = 13;
            else coefficient = 16;
        }

        if(employeeType == 'C'){
            if(year <= 3) coefficient = 9;
            else if(year <= 8) coefficient = 10;
            else if(year <= 15) coefficient = 12;
            else coefficient = 14;
        }

        if(employeeType == 'D'){
            if(year <= 3) coefficient = 8;
            else if(year <= 8) coefficient = 9;
            else if(year <= 15) coefficient = 11;
            else coefficient = 13;
        }
        return unitSalary * coefficient * numWork * 1000;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", id, name, getTotalSalary());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        HashMap<String, String> mp = new HashMap<>();
        while(q-->0){
            String id = sc.next();
            String name = sc.nextLine();
            mp.put(id, name);
        }
        int n = sc.nextInt();
        ArrayList<Employee> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int unitSalary = sc.nextInt();
            int numWork = sc.nextInt();
            Employee employee = new Employee(id, name, unitSalary, numWork);
            employee.setDepartment(mp.get(id.substring(3)));
            list.add(employee);
        }
        String id = sc.next();
        System.out.println("Bang luong phong"+mp.get(id)+":");
        for(Employee employee : list){
            if(employee.getId().substring(3).equals(id)){
                System.out.println(employee);
            }
        }
    }
}