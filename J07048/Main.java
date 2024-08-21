import java.util.*;
import java.io.*;

class Item implements Comparable<Item>{
    private String id, name;
    private int sellPrice, month;

    public Item(String id, String name, int sellPrice, int month) {
        this.id = id;
        this.name = name;
        this.sellPrice = sellPrice;
        this.month = month;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", id, name, sellPrice, month);
    }

    @Override
    public int compareTo(Item o) {
        if(this.sellPrice == o.sellPrice) return this.id.compareTo(o.id);
        return -Integer.compare(this.sellPrice, o.sellPrice);
    }
}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        int n = sc.nextInt();
        ArrayList<Item> list = new ArrayList<>();
        for(int i = 0;i < n; i++) {
            String id = sc.next();
            sc.nextLine();
            list.add(new Item(id, sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);
        for(Item item : list) System.out.println(item);
    }
}