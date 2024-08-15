import java.util.*;
import java.io.*;
class Goods{
    private String id, name, level;
    private int quantityImport, unitPrice, quantityExport;

    public Goods(String id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public String getId(){
        return this.id;
    }

    public void setQuantityImport(int quantityImport){
        this.quantityImport = quantityImport;
    }

    public void setQuantityExport(int quantityExport){
        this.quantityExport = quantityExport;
    }

    public void setUnitPrice(int unitPrice){
        this.unitPrice = unitPrice;
    }
    public int getTotalImport(){
        return quantityImport * unitPrice;
    }
    public int getTotalExport(){
        double tax;
        if(level.charAt(0) == 'A') tax = 1.08;
        else if(level.charAt(0) == 'B') tax = 1.05;
        else tax = 1.02;
        return (int)Math.round(quantityExport * unitPrice * tax);
    }
    @Override
    public String toString() {
        return String.format("%s %s %d %d", id, name, getTotalImport(), getTotalExport());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Goods> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String level = sc.next();
            list.add(new Goods(id, name, level));
        }
        int q = sc.nextInt();
        for( int i = 0; i < q; i++){
            String id = sc.next();
            int quantityImport = sc.nextInt();
            int unitPrice = sc.nextInt();
            int quantityExport = sc.nextInt();
            for(int j = 0; j < n; j++){
                if(list.get(j).getId().equals(id)){
                    list.get(j).setQuantityExport(quantityExport);
                    list.get(j).setQuantityImport(quantityImport);
                    list.get(j).setUnitPrice(unitPrice);
                    System.out.println(list.get(j));
                    break;
                }
            }

        }

    }
}