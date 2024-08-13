import java.util.*;
import java.io.*;
class Item{
    private String name, unit, id = "MH";
    private int unitPrice, quantity;

    public Item(String name, String unit, int unitPrice, int quantity, int id) {
        this.name = name;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        if(id < 10) this.id += "0";
        this.id += Integer.toString(id);
    }
    public int getShippingFee(){
        return (int)Math.round(quantity * unitPrice* 5.0/100.0);
    }
    public int getTotal(){
        return (int)(unitPrice * quantity + getShippingFee());
    }
    public int getSellPrice(){
        double sellPrice = getTotal()*102.0/(100.0);
        sellPrice /= quantity;
        return (int)(Math.ceil(sellPrice/100.0)*100.0);

    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d %d", id, name, unit, getShippingFee(), getTotal(), getSellPrice());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Item> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String name = sc.next();
            String unit = sc.next();
            int unitPrice = sc.nextInt();
            int quantity = sc.nextInt();
            list.add(new Item(name, unit, unitPrice, quantity, i));
        }
        Collections.sort(list, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if(o1.getSellPrice() > o2.getSellPrice()) return -1;
                return 1;
            }
        });
        for(Item item : list){
            System.out.println(item);
        }
    }
}