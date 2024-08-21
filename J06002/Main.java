import java.util.*;
import java.io.*;

class Item{
    private String id, name;
    private long unitPrice1, unitPrice2;

    public Item(String id, String name, long unitPrice1, long unitPrice2) {
        this.id = id;
        this.name = name;
        this.unitPrice1 = unitPrice1;
        this.unitPrice2 = unitPrice2;
    }

    public Item() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getUnitPrice1() {
        return unitPrice1;
    }

    public long getUnitPrice2() {
        return unitPrice2;
    }
}

class Invoice implements Comparable<Invoice>{
    private Item item = new Item();
    private int quantity;
    private String id = "";

    public Invoice(String id, int quantity, int i) {
        this.quantity = quantity;
        this.id = id + "-0";
        if (i < 10) this.id += '0';
        this.id += Integer.toString(i);
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public long getCost(){
        if(id.charAt(2) == '1') return quantity * item.getUnitPrice1();
        else return quantity * item.getUnitPrice2();
    }

    public long getDiscount(){
        if(quantity >= 150) return (long) (getCost() * 0.5);
        else if(quantity >= 100) return (long) (getCost() * 0.3);
        else if(quantity >= 50) return  (long) (getCost() * 0.15);
        return 0;
    }

    public long getFinalCost(){
        return getCost() - getDiscount();
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", id, item.getName(), getDiscount(), getFinalCost());
    }

    @Override
    public int compareTo(Invoice o) {
        return -Long.compare(this.getFinalCost(), o.getFinalCost());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Item> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            long unitPrice1 = sc.nextLong();
            long unitPrice2 = sc.nextLong();
            map.put(id, new Item(id, name, unitPrice1, unitPrice2));
        }
        n = sc.nextInt();
        ArrayList<Invoice> list = new ArrayList<>();
        for(int i = 1;i <= n; i++){
            String id = sc.next();
            int quantity = sc.nextInt();
            Invoice invoice = new Invoice(id, quantity, i);
            invoice.setItem(map.get(id.substring(0,2)));
            list.add(invoice);
        }
        Collections.sort(list);
        for(Invoice invoice : list){
            System.out.println(invoice);
        }
    }
}