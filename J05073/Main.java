import java.util.*;
import java.io.*;

class Product{
    private String id;
    private int unitPrice, quantity;
    private static HashMap<Character, Double> tax = new HashMap<>();
    private static HashMap<Character, Double> ship = new HashMap<>();
    public Product(String id, int unitPrice, int quantity) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        tax.put('T', 0.29);
        tax.put('C', 0.1);
        tax.put('D', 0.08);
        tax.put('M', 0.02);
        ship.put('T', 0.04);
        ship.put('C', 0.03);
        ship.put('D', 0.025);
        ship.put('M', 0.005);
    }
    public double getUnitPrice(){
        double discount = 0;
        if(id.charAt(id.length()-1) == 'C') discount = 0.05;
        double price = unitPrice * quantity;
        double taxPrice = price * tax.get(id.charAt(0)) * (1-discount);
        double shipPrice = price * ship.get(id.charAt(0));
        return (price + taxPrice + shipPrice)*1.2/(double) quantity;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", id, getUnitPrice());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <=n; i++){
            System.out.println(new Product(sc.next(), sc.nextInt(), sc.nextInt()));
        }
    }
}