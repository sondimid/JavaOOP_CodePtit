import java.util.*;
import java.io.*;
class Student{
    private String id,name,lop,email;

    public Student(String id, String name, String lop, String email) {
        this.id = id;
        this.name = name;
        this.lop = lop;
        this.email = email;
    }

    public String getLop() {
        return lop;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", this.id, this.name, this.lop, this.email);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String lop = sc.next();
            String email = sc.next();
            list.add(new Student(id, name, lop, email));
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getLop().equals(o2.getLop())){
                    return o1.getId().compareTo(o2.getId());
                }
                else return o1.getLop().compareTo(o2.getLop());
            }
        });
        for(Student student : list){
            System.out.println(student);
        }
    }
}