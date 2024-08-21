import java.util.*;
import java.io.*;

class Customer{
    private String id = "KH0", name, gender, birth, address;

    public Customer(int id, String name, String gender, String birth, String address) {
        if(id < 10) this.id +='0';
        this.id += Integer.toString(id);
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirth() {
        return birth;
    }

    public String getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }
}

class Item{
    private String id = "MH0", name, unit;
    private long purchasePrice, sellPrice;

    public Item(int id, String name, String unit, long purchasePrice, long sellPrice) {
        if(id < 10) this.id +='0';
        this.id += Integer.toString(id);
        this.name = name;
        this.unit = unit;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public long getPurchasePrice() {
        return purchasePrice;
    }

    public long getSellPrice() {
        return sellPrice;
    }
}
class Invoice{
    private String id = "HD0";
    private Customer customer;
    private Item item;
    private long quantity;

    public Invoice(Customer customer, Item item, long quantity,int id) {
        this.customer = customer;
        this.item = item;
        this.quantity = quantity;
        if(id < 10) this.id +='0';
        this.id += Integer.toString(id);
    }

    public long getCost(){
        return quantity * item.getSellPrice();
    }
    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %d %d %d %d", id, customer.getName(), customer.getAddress(), item.getName(), item.getUnit(), item.getPurchasePrice(), item.getSellPrice(), quantity, getCost());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Customer> map1 = new HashMap<>();
        HashMap<String, Item> map2 = new HashMap<>();
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            String name = sc.nextLine();
            String gender = sc.next();
            String birth = sc.next();
            sc.nextLine();
            String address = sc.nextLine();
            Customer customer = new Customer(i, name, gender, birth, address);
            map1.put(customer.getId(), customer);
        }

        int m = sc.nextInt();
        for(int  i = 1; i <= m; i++){
            sc.nextLine();
            String name = sc.nextLine();
            String unit = sc.next();
            long purchasePrice = sc.nextLong();
            long sellPrice = sc.nextLong();
            Item item = new Item(i, name, unit, purchasePrice, sellPrice);
            map2.put(item.getId(), item);
        }

        int k = sc.nextInt();
        ArrayList<Invoice> list = new ArrayList<>();
        for(int i = 1; i <= k; i++){
            String idCustomer = sc.next();
            String idItem = sc.next();
            long quantity = sc.nextLong();
            list.add(new Invoice(map1.get(idCustomer), map2.get(idItem), quantity, i));
        }
        for(Invoice invoice : list){
            System.out.println(invoice);
        }
    }
}