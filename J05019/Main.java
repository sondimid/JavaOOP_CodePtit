import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Measurement{
    private String name, id = "T";
    private long time;
    private long volume;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    public Measurement(String name, String start, String end, long volume, int id) {
        this.name = name;
        try {
            this.time = (sdf.parse(end).getTime() - sdf.parse(start).getTime()) ;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.volume = volume;
        if(id < 10) this.id +='0';
        this.id += Integer.toString(id);
    }

    public void setTime(String start, String end) {
        try {
            this.time += sdf.parse(end).getTime() - sdf.parse(start).getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void setVolume(long volume) {
        this.volume += volume;
    }

    public String getName() {
        return name;
    }

    public double getAvg(){
        double hour = time / 3600000.0;
        return volume / hour;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", id, name, getAvg());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Measurement> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            String name = sc.nextLine();
            String start = sc.next();
            String end = sc.next();
            long volume = sc.nextLong();
            boolean check = true;
            for(int j = 0; j < list.size(); j++){
                if(list.get(j).getName().equals(name)){
                    list.get(j).setVolume(volume);
                    list.get(j).setTime(start, end);
                    check = false;
                    break;
                }
            }
            if(check == true){
                list.add(new Measurement(name, start, end, volume, i));
            }
        }
        for(Measurement measurement : list){
            System.out.println(measurement);
        }
    }
}