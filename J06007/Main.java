import java.util.*;
import java.io.*;

class Teacher{
    private String id, name;
    private double time = 0;

    public Teacher(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTime(double time) {
        this.time += time;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", name, time);
    }

}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
        }

        ArrayList<Teacher> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        n = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= n;i++){
            String line = sc.nextLine();
            String id = line.substring(0,4);
            String name = line.substring(5);
            map.put(id, name);
            list.add(new Teacher(id, name));
        }
        n = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            String[] s = sc.nextLine().trim().split("\\s+");
            for(int j = 0; j < list.size(); j++){
                if(list.get(j).getId().equals(s[0])){
                    list.get(j).setTime(Double.parseDouble(s[2]));
                }
            }
        }
        for(Teacher teacher : list) System.out.println(teacher);
    }
}