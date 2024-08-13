import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
class Employee{
    private String id, name, gender, birth, address, taxCode, contractDate;

    public Employee(String name, String gender, String birth, String address, String taxCode, String contractDate) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
        this.taxCode = taxCode;
        this.contractDate = contractDate;
        this.id = "000";
    }

    public void setId(int cnt) {
        if(cnt >= 10){
            this.id += Integer.toString(cnt);
        }
        else this.id += '0' + Integer.toString(cnt);
    }

    public String getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return this.id+" "+this.name+" "+this.gender+" "+this.birth+" "+this.address+" "+this.taxCode+" "+this.contractDate;
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Employee> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            Employee e =  new Employee(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine());
            e.setId(i+1);
            list.add(e);
        }
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date d1 = sdf.parse(o1.getBirth());
                    Date d2 = sdf.parse(o2.getBirth());
                    return d1.compareTo(d2);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        for(Employee e : list){
            System.out.println(e);
        }
    }
}