import java.util.*;
import java.io.*;
class Student{
    private String numOrder, id, name, lop, email, company;

    public Student(String numOrder, String id, String name, String lop, String email, String company) {
        this.numOrder = numOrder;
        this.id = id;
        this.name = name;
        this.lop = lop;
        this.email = email;
        this.company = company;
    }

    public String getNumOrder() {
        return numOrder;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLop() {
        return lop;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s", this.numOrder, this.id, this.name, this.lop, this.email, this.company);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String lop = sc.next();
            String email = sc.next();
            String company = sc.next();
            list.add(new Student(Integer.toString(i), id, name, lop, email, company));
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        int q = sc.nextInt();
        while (q-->0){
            String company = sc.next();
            for(Student student : list){
                if(student.getCompany().equals(company)){
                    System.out.println(student);
                }
            }
        }
    }
}