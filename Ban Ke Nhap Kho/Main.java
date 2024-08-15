import java.util.*;

class Shipment {
    private String id,name;
    private int quantity,unitPrice;
    private double discount;
    private static HashMap<String,Integer> mp = new HashMap<>();

    public Shipment(String name, int quantity, int unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        String[] s = name.split("\\s+");
        this.id = String.format("%c%c", Character.toUpperCase(s[0].charAt(0)) ,Character.toUpperCase(s[1].charAt(0)));
        if(!mp.containsKey(this.id)){
            mp.put(this.id,1);
        }
        int cnt = mp.get(this.id);
        mp.replace(this.id,cnt+1);
        this.id += '0' +Integer.toString(cnt);
        if(this.quantity>10) this.discount = (int) (5.0/100 * this.quantity * this.unitPrice);
        else if(this.quantity>=8) this.discount = (int) (2.0/100*this.quantity*this.unitPrice);
        else if(this.quantity>=5) this.discount = (int)(1.0/100*this.quantity*this.unitPrice);
        else this.discount = 0;
    }
    public int getTotal(){
        return this.quantity*this.unitPrice-(int)(this.discount);
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

    public static HashMap<String, Integer> getMp() {
        return mp;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LinkedList<Shipment> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            Shipment s = new Shipment(sc.nextLine(),sc.nextInt(),sc.nextInt());
            list.add(s);
            sc.nextLine();
        }
        Collections.sort(list, new Comparator<Shipment>() {
            @Override
            public int compare(Shipment o1, Shipment o2) {
                if(o1.getDiscount() > o2.getDiscount()) return -1;
                return 1;
            }
        });
        for(Shipment s :list){
            System.out.println(s.getId()+" "+s.getName()+" "+s.getDiscount()+" "+s.getTotal());
        }
    }
}
