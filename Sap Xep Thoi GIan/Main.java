import java.util.*;

class Time {
    private int hour,minute,second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> t = new ArrayList<>();
        for(int i=0;i<n;i++){
            t.add(new Time(sc.nextInt(),sc.nextInt(),sc.nextInt()) );
        }
        Collections.sort(t, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.getHour()==o2.getHour()) {
                    if(o1.getMinute()==o2.getMinute()){
                        if(o1.getSecond()>o2.getSecond()) return 1;
                        else return -1;
                    }
                    else if(o1.getMinute()>o2.getMinute()) return 1;
                    else return -1;
                }
                else if(o1.getHour()>o2.getHour()) return 1;
                else return -1;
            }
        });
        for(Time x:t){
            System.out.println(x.getHour()+" "+x.getMinute()+" "+x.getSecond());
        }
    }
}
