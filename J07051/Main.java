import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Customer implements Comparable<Customer>{
    private String name, id = "KH", room;
    private int serviceFee;
    private long numDay;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Customer(String name, String room, String start, String end, int serviceFee, int id) {
        this.room = room;
        this.serviceFee = serviceFee;
        if(id < 10) this.id +='0';
        this.id += Integer.toString(id);
        try {
            this.numDay = (sdf.parse(end).getTime() - sdf.parse(start).getTime()) / (1000*24*3600) + 1;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.name = "";
        String[] s = name.trim().toLowerCase().split("\\s+");
        for(int i = 0; i < s.length;i ++){
            StringBuilder sb = new StringBuilder(s[i]);
            sb.setCharAt(0, Character.toUpperCase(s[i].charAt(0)));
            this.name += sb.toString() + " ";
        }


    }
    public long getCost(){;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,25);
        map.put(2,34);
        map.put(3,50);
        map.put(4,80);
        return map.get(Integer.parseInt(room.substring(0,1))) * numDay + serviceFee;
    }

    @Override
    public String toString() {
        return String.format("%s %s%s %d %d", id, name, room, numDay, getCost());
    }

    @Override
    public int compareTo(Customer o) {
        return -Long.compare(this.getCost(), o.getCost());
    }
}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = sc.nextInt();
        ArrayList<Customer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            list.add(new Customer(sc.nextLine(), sc.next(), sc.next(), sc.next(), sc.nextInt(), i));
        }
        Collections.sort(list);
        for(Customer customer : list) System.out.println(customer);
    }
}