import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

class Invoice implements Comparable<Invoice>{
    private String name, numRoom, id = "KH";
    private int incidentalCost;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date start, end;
    HashMap<Integer, Integer> mp = new HashMap<>();

    public Invoice(String name, String numRoom, String start, String end, int incidentalCost, int id) {
        this.name = name;
        this.numRoom = numRoom;
        try {
            this.start = sdf.parse(start);
            this.end = sdf.parse(end);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.incidentalCost = incidentalCost;
        mp.put(1, 25);
        mp.put(2, 34);
        mp.put(3, 50);
        mp.put(4, 80);
        if(id < 10) this.id +="0";
        this.id += Integer.toString(id);
    }

    public long getDuration(){
        return 1 + TimeUnit.DAYS.convert(end.getTime() - start.getTime(), TimeUnit.MILLISECONDS);
    }

    public int getTotalCost(){
        return (int)getDuration() * mp.get(Integer.parseInt(numRoom.substring(0,1))) + incidentalCost;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d", id, name, numRoom, getDuration(), getTotalCost());
    }

    @Override
    public int compareTo(Invoice o) {
        return -Integer.compare(this.getTotalCost(), o.getTotalCost());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Invoice> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            list.add(new Invoice(sc.nextLine(),sc.next(), sc.next(), sc.next(), sc.nextInt(), i));
        }
        Collections.sort(list);
        for(Invoice invoice : list){
            System.out.println(invoice);
        }
    }
}