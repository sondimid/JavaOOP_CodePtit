import java.util.*;
import java.io.*;
class Business{
    private String id,name;
    private int quantity;

    public Business(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return String.format("%s %s %d", this.id, this.name, this.quantity);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Business> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int quantity = sc.nextInt();
            list.add(new Business(id, name, quantity));
        }
        Collections.sort(list, new Comparator<Business>() {
            @Override
            public int compare(Business o1, Business o2) {
                if(o1.getQuantity() == o2.getQuantity()){
                    return o1.getId().compareTo(o2.getId());
                }
                else{
                    if(o1.getQuantity() > o2.getQuantity()) return -1;
                    else return 1;
                }
            }
        });
        for(Business business : list){
            System.out.println(business);
        }
    }
}