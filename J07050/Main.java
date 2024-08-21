import java.util.*;
import java.io.*;

class Item implements Comparable<Item>{
    private String name, group, id = "MH";
    private double purchasePirce, sellPrice;

    public Item(String name, String group, double purchasePirce, double sellPrice, int id) {
        this.name = name;
        this.group = group;
        this.purchasePirce = purchasePirce;
        this.sellPrice = sellPrice;
        if(id < 10) this.id += '0';
        this.id += Integer.toString(id);
    }

    public double getProfit(){
        return sellPrice - purchasePirce;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.2f", id, name, group, getProfit());
    }

    @Override
    public int compareTo(Item o) {
        return -Double.compare(this.getProfit(), o.getProfit());
    }
}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATHANG.in"));
        int n = sc.nextInt();
        ArrayList<Item> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            list.add(new Item(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), i));
        }
        Collections.sort(list);
        for(Item item : list) System.out.println(item);
    }
}