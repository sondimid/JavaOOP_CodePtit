import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
        for(Shipment s :list){
            System.out.println(s.getId()+" "+s.getName()+" "+s.getDiscount()+" "+s.getTotal());
        }
    }
}
