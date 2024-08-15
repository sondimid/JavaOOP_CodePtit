import java.util.*;
import java.io.*;
class Invoice{
    private String name, id;
    private int unitPrice, quantity;

    public Invoice(String name, String id, int unitPrice, int quantity) {
        this.name = name;
        this.id = id;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    public String getNumOrder(){
        return id.substring(1,4);
    }
    public int getDiscount(){
        int disc;
        if(id.charAt(id.length()-1) == '1') disc = (int)(unitPrice * quantity *0.5f);
        else disc = (int)(unitPrice * quantity * 0.3f);
        return disc;
    }
    public int getTotalPay(){
        return quantity * unitPrice - getDiscount();
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d", name, id, getNumOrder(), getDiscount(), getTotalPay());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Invoice> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            sc.nextLine();
            list.add(new Invoice(sc.nextLine(),sc.next(),sc.nextInt(), sc.nextInt()));
        }
        for(Invoice invoice : list){
            System.out.println(invoice);
        }
    }
}