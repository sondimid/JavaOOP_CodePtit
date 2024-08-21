import java.util.*;
import java.io.*;

class Subject implements Comparable<Subject>{
    private String id, name;
    private int num;

    public Subject(String id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", id, name, num);

    }

    @Override
    public int compareTo(Subject o) {
        return this.name.compareTo(o.name);
    }
}
public class Main {
    public static void main(String[] arg) {
        try {
            Scanner sc = new Scanner(new File("MONHOC.in"));
            int n = sc.nextInt();
            ArrayList<Subject> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String id = sc.next();
                sc.nextLine();
                String name = sc.nextLine();
                int num = sc.nextInt();
                list.add(new Subject(id, name, num));
            }
            Collections.sort(list);
            for(Subject subject: list) System.out.println(subject);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}