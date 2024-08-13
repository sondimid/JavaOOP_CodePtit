
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

class Time{
    private String id, name;
    private Date start, end;
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

    public Time(String id, String name, String start, String end) {
        this.id = id;
        this.name = name;
        try {
            this.start = dateFormat.parse(start);
            this.end = dateFormat.parse(end);
        } catch (Exception e) {
           // throw new RuntimeException(e);
        }
    }
    public long getDuration(){
        return this.end.getTime() - this.start.getTime();
    }

    @Override
    public String toString() {
        return String.format("%s %s %d gio %d phut",this.id, this.name, (int) this.getDuration()/(1000*3600), (int) this.getDuration()/(1000*60)%60);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> list = new ArrayList<>();
        for(int i = 0; i < n; i++ ){
            String id=sc.next();
            sc.nextLine();
            String name=sc.nextLine();
            String startDate=sc.next();
            String endDate=sc.next();
            list.add(new Time(id, name, startDate, endDate));
        }
        Collections.sort(list, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.getDuration() > o2.getDuration()) return -1;
                return 1;
            }
        });
        for(Time time: list){
            System.out.println(time);
        }
    }


}