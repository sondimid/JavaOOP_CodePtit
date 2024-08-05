import java.util.HashMap;

public class Shipment {
    private String id,name;
    private int quantity,unitPrice;
    private double discount;
    private static HashMap<String,Integer> mp = new HashMap<>();

    public Shipment(String name, int quantity, int unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        String[] s = name.split("\\s+");
        this.id = String.format("%c%c",Character.toUpperCase(s[0].charAt(0)),Character.toUpperCase(s[1].charAt(0)));
        if(!mp.containsKey(this.id)){
            mp.put(this.id,1);
        }
        int cnt = mp.get(this.id);
        mp.replace(this.id,cnt+1);
        this.id += '0'+ Integer.toString(cnt);
        if(this.quantity>10) this.discount = 5.0/100;
        else if(this.quantity>=8) this.discount = 2.0/100;
        else if(this.quantity>=5) this.discount = 1.0/100;
        else this.discount = 0;
        this.discount *= this.unitPrice*this.quantity;
    }
    public int getTotal(){
        return (int)this.unitPrice*this.quantity-(int)this.discount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getDiscount() {
        return (int)discount;
    }
}
