import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
    private String id, name = "", lop, email;

    public Student(String id, String name, String lop, String email) {
        this.id = id;
        this.lop = lop;
        this.email = email;
        String[] s = name.toLowerCase().trim().split("\\s+");
        for(int i = 0; i < s.length; i++){
            this.name += Character.toUpperCase(s[i].charAt(0)) + s[i].substring(1) + " ";
        }
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s %s%s", id, name, lop);
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }
}

class Company{
    private String id, name;
    private int quantity;
    private ArrayList<Student> list = new ArrayList<>();

    public Company(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setList(Student student){
        this.list.add(student);
    }

    public void display(){
        for(Student student : list){
            System.out.println(student);
        }
    }
}

class Internship implements Comparable<Internship>{
    private String idStudent, idCompany;

    public Internship(String idStudent, String idCompany) {
        this.idStudent = idStudent;
        this.idCompany = idCompany;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public String getIdCompany() {
        return idCompany;
    }

    @Override
    public int compareTo(Internship o) {
        return this.idStudent.compareTo(o.idStudent);
    }
}
public class Main {
    public static void main(String[] arg) throws IOException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = sc.nextInt();
        ArrayList<Student> studentsList = new ArrayList<>();
        for(int i = 0 ;i < n; i++){
            String id = sc.next();
            sc.nextLine();
            studentsList.add(new Student(id, sc.nextLine(), sc.next(), sc.next()));
        }
        Collections.sort(studentsList);

        HashMap<String, String> mp = new HashMap<>();
        Scanner sc1 = new Scanner(new File("DN.in"));
        n = sc1.nextInt();
        ArrayList<Company> companiesList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            mp.put(id, name);
            companiesList.add(new Company(id, name, sc1.nextInt()));
        }

        Scanner sc2 = new Scanner(new File("THUCTAP.in"));
        n = sc2.nextInt();
        sc2.nextLine();
        ArrayList<Internship> internList = new ArrayList<>();

        while(n-->0){
            String[] s = sc2.nextLine().split("\\s+");
            String idStudent = s[0];
            String idCompany = s[1];
            internList.add(new Internship(idStudent, idCompany));

        }
        Collections.sort(internList);

        for(Internship internship  : internList){
            for(int i = 0; i < companiesList.size(); i++){
                if(companiesList.get(i).getId().equals(internship.getIdCompany())){
                    for(Student student : studentsList){
                        if(student.getId().equals(internship.getIdStudent()) && companiesList.get(i).getQuantity() > 0){
                            companiesList.get(i).setList(student);
                            companiesList.get(i).setQuantity(companiesList.get(i).getQuantity()-1);
                        }
                    }
                }
            }
        }
        int q = sc2.nextInt();
        while(q-->0){
            String id = sc2.next();
            System.out.println("DANH SACH THUC TAP TAI " + mp.get(id) +":");
            for(Company company : companiesList){
                if(company.getId().equals(id)){
                    company.display();
                }
            }
        }
    }
}