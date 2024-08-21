import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Exam implements Comparable<Exam>{
    private String id = "C", day, hour, room;
    private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

    public Exam(String day, String hour, String room, int id) {
        this.id += String.format("%03d", id);
        this.day = day;
        this.hour = hour;
        this.room = room;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", id, day, hour, room);
    }

    @Override
    public int compareTo(Exam o) {
        if(this.day.equals(o.day)){
            if(this.hour.equals(o.hour)) return this.id.compareTo(o.id);
            try {
                return sdf2.parse(this.hour).compareTo(sdf2.parse(o.hour));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            return sdf1.parse(this.day).compareTo(sdf1.parse(o.day));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("CATHI.in"));
        int n = sc.nextInt();
        ArrayList<Exam> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(new Exam(sc.next(), sc.next(), sc.next(), i));
        }
        Collections.sort(list);
        for(Exam exam : list) System.out.println(exam);
    }
}