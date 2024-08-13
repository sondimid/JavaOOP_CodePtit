import java.util.*;
import java.io.*;
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
    public String getMajor(){
        return this.id.substring(5,7);
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
        int q = sc.nextInt();
        sc.nextLine();
        Map<String, String> mp = new HashMap<>();
        mp.put("KE TOAN","KT");
        mp.put("CONG NGHE THONG TIN","CN");
        mp.put("AN TOAN THONG TIN","AT");
        mp.put("VIEN THONG","VT");
        mp.put("DIEN TU","DT");
        while(q-->0){
            String tmp = sc.nextLine();
            tmp = tmp.toUpperCase();
            System.out.println("DANH SACH SINH VIEN NGANH "+tmp+":");
            for(Student student : list){
                if(student.getMajor().equals(mp.get(tmp))){
                    if(mp.get(tmp).equals("CN") || mp.get(tmp).equals("AT")){
                        if(student.getLop().charAt(0) != 'E'){
                            System.out.println(student);
                        }
                    }
                    else System.out.println(student);
                }
            }
        }
    }
}