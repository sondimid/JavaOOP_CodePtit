import java.util.*;
import java.io.*;

class Invoice implements Comparable<Invoice>{
    private String id, name;
    private long quantity, unitPrice, tax, totalPrice;

    public Invoice(String id, long quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return quantity;
    }

    public long getTax() {
        return tax;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setTax(long tax) {
        this.tax = tax;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d", id, name, unitPrice, tax, totalPrice);
    }

    @Override
    public int compareTo(Invoice o) {
        if(this.totalPrice > o.totalPrice) return -1;
        return 1;
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> mp = new HashMap<>();
        mp.put("BP", "British Petro");
        mp.put("ES", "Esso");
        mp.put("SH", "Shell");
        mp.put("CA", "Castrol");
        mp.put("MO", "Mobil");
        mp.put("TN", "Trong Nuoc");
        HashMap<Character, Long> mp1 = new HashMap<>();
        mp1.put('X', 128000L);
        mp1.put('D', 11200L);
        mp1.put('N', 9700L);
        HashMap<Character, Double> mp2 = new HashMap<>();
        mp2.put('X', .03);
        mp2.put('D', .035);
        mp2.put('N', .02);
        int n = sc.nextInt();
        ArrayList<Invoice> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String id = sc.next();
            Long quantity = sc.nextLong();
            Invoice invoice = new Invoice(id, quantity);
            invoice.setName(mp.get(id.substring(id.length()-2)));
            invoice.setUnitPrice(mp1.get(id.charAt(0)));
            if(id.substring(id.length()-2).equals("TN")) invoice.setTax(0);
            else invoice.setTax((int)(mp2.get(id.charAt(0)) * invoice.getUnitPrice() *invoice.getQuantity()));
            invoice.setTotalPrice(invoice.getUnitPrice() * invoice.getQuantity() + invoice.getTax());
            list.add(invoice);
        }
        Collections.sort(list);
        for(Invoice invoice : list){
            System.out.println(invoice);
        }
    }
}