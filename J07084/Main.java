import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
    private String name;
    private long time;
    private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");

    public Student(String name, String startDate, String startHour, String endDate, String endHour) {
        this.name = name;
        try {
            this.time = (sdf1.parse(endDate).getTime() + sdf2.parse(endHour).getTime() - sdf1.parse(startDate).getTime() - sdf2.parse(startHour).getTime()) / (1000 * 60);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d", name, time);
    }

    @Override
    public int compareTo(Student o) {
        if(this.time == o.time) return this.name.compareTo(o.name);
        return Long.compare(o.time, this.time);
    }

}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("ONLINE.in"));
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            sc.nextLine();
            list.add(new Student(sc.nextLine(), sc.next(), sc.next(), sc.next(), sc.next()));
        }
        Collections.sort(list);
        for(Student student : list) System.out.println(student);
    }
}