import java.util.*;
import java.io.*;
class Teacher{
    private String name, id="GV", major;

    public Teacher(String name, String major, String id) {
        this.name = name;
        this.major = major;
        if(Integer.parseInt(id) < 10) this.id += "0";
        this.id += id;
        String[] s = this.major.split("\\s+");
        this.major="";
        for(int i = 0; i < s.length; i++){
            this.major += Character.toUpperCase(s[i].charAt(0));
        }
    }

    public String getName() {
        String[] s = this.name.split("\\s+");
        return s[s.length-1];
    }

    public String getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.id ,this.name, this.major);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Teacher> list = new ArrayList<>();
        for(int i = 1; i <= n ; i++){
            String name = sc.nextLine();
            String major = sc.nextLine();
            list.add(new Teacher(name,major,Integer.toString(i)));
        }
        Collections.sort(list, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                if(o1.getName().equals(o2.getName())){
                    return o1.getMajor().compareTo(o2.getMajor());
                }
                else return o1.getName().compareTo(o2.getName());
            }
        });
        for(Teacher teacher: list){
            System.out.println(teacher);
        }
    }
}