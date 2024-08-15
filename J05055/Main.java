import java.text.ParseException;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;


class Person{
    private String name, birth;
    public SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    private Date start , end;

    public Person(String name, String birth, String start, String end) {
        this.name = name;
        this.birth = birth;
        try {
            this.start = sdf.parse(start);
            this.end = sdf.parse(end);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public int getAge(){
        return 2021 - Integer.parseInt(birth.substring(birth.length()-4));
    }

    public String getRealTime(){
        Duration realTime = Duration.between((Temporal) start, (Temporal) end);
        long hour = realTime.toHours();
        long minute = realTime.toMinutes() % 60;
        long second = realTime.toSeconds() % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    public String getPriority(){
        if(getAge() < 18) return
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

    }
}