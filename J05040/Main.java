import java.util.*;

class Employee{
    private String name, level,id="NV";
    private int dailyWage, numWork;

    public Employee(String name, int dailyWage, int numWork, String level,int id) {
        this.name = name;
        this.dailyWage = dailyWage;
        this.numWork = numWork;
        this.level = level;
        if(id < 10) this.id +="0";
        this.id += Integer.toString(id);
    }
    public int getMonthSalary(){
        return dailyWage * numWork;
    }
    public int getBonus(){
        if(numWork >= 25) return getMonthSalary()/5;
        if(numWork >= 22) return getMonthSalary()/10;
        return 0;
    }
    public int getLevelBonus(){
        if(level.equals("GD")) return 250000;
        else if(level.equals("PGD")) return 200000 ;
        else if(level.equals("TP")) return 180000;
        else return 150000;
    }
    public int getTotalSalary(){
        return getBonus() + getMonthSalary() + getLevelBonus();
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", id, name, getMonthSalary(), getBonus(), getLevelBonus(), getTotalSalary());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Employee> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(new Employee(sc.nextLine(), sc.nextInt(), sc.nextInt(), sc.next(), i));
            sc.nextLine();
        }
        int sum = 0;
        for(Employee employee : list){
            System.out.println(employee);
            sum += employee.getTotalSalary();
        }
    }
}