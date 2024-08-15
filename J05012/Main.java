import java.util.*;
import java.io.*;
class Items implements Comparable<Items>{
    private String id, name;
    private long quantity, unitPrice, tax;

    public Items(String id, String name, long quantity, long unitPrice, long tax) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.tax = tax;
    }
    public long getTotal(){
        return quantity * unitPrice - tax;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", id, name, quantity, unitPrice, tax, getTotal());
    }

    @Override
    public int compareTo(Items o) {
        return -Long.compare(this.getTotal(), o.getTotal());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Items> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            long quantity = sc.nextLong();
            long unitPrice = sc.nextLong();
            long tax = sc.nextLong();
            list.add(new Items(id, name, quantity, unitPrice, tax));
        }
        Collections.sort(list);
        for(Items item : list){
            System.out.println(item);
        }
    }
}