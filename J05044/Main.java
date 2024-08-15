import java.util.*;

class Employee{
    private String name, level, id = "NV";
    private int salary, numWork;

    public Employee(String name, String level, int salary, int numWork, int id) {
        this.name = name;
        this.level = level;
        this.salary = salary * numWork;
        this.numWork = numWork;
        if(id < 10) this.id += '0';
        this.id += Integer.toString(id);
    }
    public int getBonus(){
        if(level.equals("GD")) return 500;
        if(level.equals("PGD")) return 400;
        if(level.equals("TP")) return 300;
        if(level.equals("KT")) return 250;
        return 100;
    }
    public int getAdvance() {
        double advance = (getBonus() + salary) * 2.0 / 3.0;
        if (advance < 25000) {
            return (int)Math.round(advance / 1000) * 1000;
        } else {
            return 25000;
        }
    }

    public int getRemain(){
        return salary + getBonus() -getAdvance();
    }
    public int getSalary(){
        return salary;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", id, name, getBonus(), getSalary(), getAdvance(), getRemain());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Employee> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(new Employee(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt(),i));
            sc.nextLine();
        }
        String level = sc.next();
        for(Employee employee : list){
            if(level.equals(employee.getLevel())){
                System.out.println(employee);
            }
        }
    }
}