import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.*;
import java.io.*;

class Customer implements Comparable<Customer>{
    private String id="KH", name, idRoom;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date start, end;

    public Customer(String name, String idRoom, String start, String end, int id) {
        this.name = name;
        this.idRoom = idRoom;
        try {
            this.start = sdf.parse(start);
            this.end = sdf.parse(end);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if(id < 10) this.id += '0';
        this.id += Integer.toString(id);
    }

    public long getDuration(){
        return (end.getTime() - start.getTime()) / (24 * 3600 * 1000);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d", id, name, idRoom, getDuration());
    }

    @Override
    public int compareTo(Customer o) {
        return -Long.compare(this.getDuration(), o.getDuration());
    }
}
public class Main {
    public static void main(String[] arg) throws IOException {
        Scanner sc = new Scanner(new File("KHACH.in"));
        int n = sc.nextInt();
        ArrayList<Customer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            list.add(new Customer(sc.nextLine(), sc.next(), sc.next(), sc.next(), i));
        }
        Collections.sort(list);
        for(Customer customer : list){
            System.out.println(customer);
        }
    }
}