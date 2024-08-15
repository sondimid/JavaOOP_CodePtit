import java.util.*;
import java.io.*;
class Club{
    private String id, name;
    private int unitPrice, revenue = 0;

    public Club(String id, String name, int unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", id, name, revenue);
    }

    public int getRevenue() {
        return revenue;
    }

    public String getName() {
        return name;
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Club> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int unitPrice = sc.nextInt();
            Club club = new Club(id, name, unitPrice);
            list.add(club);
        }
        int q = sc.nextInt();
        while(q-->0){
            String id = sc.next();
            int quantity = sc.nextInt();
            String ma = id.substring(1,3);
            for(Club club : list){
                if(club.getId().equals(ma)){
                    System.out.printf("%s %s %d", id, club.getName(), club.getUnitPrice() * quantity);
                    System.out.println();
                    break;
                }
            }
        }
    }
}