import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Person implements Comparable<Person>{
    private String name, province;
    private SimpleDateFormat sdf = new SimpleDateFormat("h:mm");
    Date end;

    public String getId(){
        String[] s = name.trim().split("\\s+");
        String ans = "";
        String[] s1 = province.trim().split("\\s+");
        for(String tmp : s1){
            ans += tmp.charAt(0);
        }
        for(String tmp: s){
            ans += tmp.charAt(0);
        }
        return ans;
    }

    public int getSpeed() {
        long seconds = 0;
        try {
            seconds = end.getTime()- sdf.parse("6:00").getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        double h = (double) seconds / 3600000.0;
        int speed = (int)Math.round(120.0/h);
        return speed;
    }

    public Person(String name, String province, String end) {
        this.name = name;
        this.province = province;
        try {
            this.end = sdf.parse(end);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d Km/h", getId(), name, province, getSpeed());
    }

    @Override
    public int compareTo(Person o) {
        return this.end.compareTo(o.end);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        ArrayList<Person> list = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            sc.nextLine();
            list.add( new Person(sc.nextLine(), sc.nextLine(), sc.next()));
        }
        Collections.sort(list);
        for(Person person : list){
            System.out.println(person);
        }
    }
}