import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LinkedList<Shipment> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            Shipment s = new Shipment(sc.nextLine(),sc.nextInt(),sc.nextInt());
            sc.nextLine();
            list.add(s);
        }
        Collections.sort(list, new Comparator<Shipment>() {
            @Override
            public int compare(Shipment o1, Shipment o2) {
                if(o1.getDiscount() < o2.getDiscount()) return 1;
                else return -1;
            }
        });
        for(Shipment s:list){
            System.out.println(s.getId()+" "+s.getName()+" "+s.getDiscount()+" "+s.getTotal());
        }
    }
}
