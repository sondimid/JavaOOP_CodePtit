import java.util.*;
class Item {
    private String id="MH0",name,unit;
    private int purchasePrice,sellPrice;

    public Item(String name, String unit, int purchasePrice, int sellPrice) {
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

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public String getUnit() {
        return unit;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setId(String id) {
        this.id = id;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Item> I = new ArrayList<>();
        for(int i=1;i<=n;i++){
            sc.nextLine();
            Item a = new Item(sc.nextLine(),sc.next(),sc.nextInt(), sc.nextInt());
            I.add(a);
            if(i<10){
                a.setId(a.getId()+'0'+Integer.toString(i));
            }
            else a.setId(a.getId()+Integer.toString(i));
        }
        Collections.sort(I, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if(o1.getSellPrice()-o1.getPurchasePrice() == o2.getSellPrice()-o2.getPurchasePrice()){
                    return o1.getId().compareTo(o2.getId());
                }
                else if(o1.getSellPrice()-o1.getPurchasePrice() < o2.getSellPrice()-o2.getPurchasePrice()) return 1;
                else return -1;
            }
        });
        for(Item i : I){
            int profit = i.getSellPrice()-i.getPurchasePrice();
            System.out.println(i.getId()+" "+i.getName()+" "+i.getUnit()+" "+i.getPurchasePrice()+" "+i.getSellPrice()+" "+profit);
        }
    }
}
