import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
    private String id, name, phoneNum, email;
    private String[] s;

    public Student(String id, String name, String phoneNum, String email) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.s = name.trim().split("\\s+");
    }

    public String getFirstName(){
        return s[s.length - 1];
    }

    public String getLastName(){
        return s[0];
    }
    public String getMidName(){
        String ans = "";
        for(int i = 1; i < s.length -1; i++ ) ans += s[i];
        return ans;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", id, name, phoneNum, email);
    }

    @Override
    public int compareTo(Student o) {
        if(this.getFirstName().equals(o.getFirstName())){
            if(this.getLastName().equals(o.getLastName())){
                if(this.getMidName().equals(o.getMidName())) return this.id.compareTo(o.id);
                return this.getMidName().compareTo(o.getMidName());
            }
            return this.getLastName().compareTo(o.getLastName());
        }
        return this.getFirstName().compareTo(o.getFirstName());
    }

}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0; i < n ;i++){
            String id = sc.next();
            sc.nextLine();
            list.add(new Student(id, sc.nextLine(), sc.next(), sc.next()));
        }
        Collections.sort(list);
        for(Student student : list) System.out.println(student);
    }
}