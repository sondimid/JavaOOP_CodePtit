import java.util.*;
import java.io.*;
class Item{
    private String name, group, id;
    private double purchasePrice, sellPrice;

    public Item(String name, String group, double purchasePrice, double sellPrice) {
        this.name = name;
        this.group = group;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
    }

    public void setId(String id) {
        this.id = id;
    }
    public double getProfit(){
        return this.sellPrice - this.purchasePrice;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.2f", this.id, this.name , this.group, this.getProfit());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Item> list = new ArrayList<>();
        for(int i = 1; i <= n; i ++){
            String name = sc.nextLine();
            String group = sc.nextLine();
            double purchasePrice = sc.nextDouble();
            double sellPrice = sc.nextDouble();
            Item item = new Item(name, group, purchasePrice, sellPrice);
            item.setId(Integer.toString(i));
            list.add(item);
            sc.nextLine();
        }
        Collections.sort(list, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if(o1.getProfit() > o2.getProfit()) return -1;
                return 1;
            }
        });
        for(Item item : list){
            System.out.println(item);
        }
    }
}