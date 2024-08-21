import java.util.*;
import java.io.*;

class Subject implements Comparable<Subject>{
    private String id, name, format;

    public Subject(String id, String name, String format) {
        this.id = id;
        this.name = name;
        this.format = format;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", id, name, format);
    }

    @Override
    public int compareTo(Subject o) {
        return this.id.compareTo(o.id);
    }
}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = sc.nextInt();
        ArrayList<Subject> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            list.add(new Subject(id, sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(list);
        for(Subject subject : list) System.out.println(subject);
    }
}