import java.util.*;
import java.io.*;
class Goods{
    private String id;
    private int numImport;

    public Goods(String id, int numImport) {
        this.id = id;
        this.numImport = numImport;
    }
    public int getNumExport(){
        double numExport;
        if(id.charAt(0) == 'A') numExport = numImport * 60.0 / 100.0;
        else numExport = numImport * 70.0 /100.0;
        return (int) Math.round(numExport);
    }
    public int getUnitPrice(){
        if (id.charAt(id.length()-1) == 'Y') return 110000;
        return 135000;
    }
    public int getMoney(){
        return getNumExport() * getUnitPrice();
    }
    public int getTax(){
        double tax;
        if(id.charAt(0) == 'A' && id.charAt(id.length()-1) =='Y') tax = getMoney() * 8.0 /100.0;
        else if(id.charAt(0) == 'A' && id.charAt(id.length()-1) =='N') tax = getMoney() * 11.0 /100.0;
        else if(id.charAt(0) == 'B' && id.charAt(id.length()-1) =='Y') tax = getMoney() * 17.0 /100.0;
        else tax = getMoney() * 22.0 /100.0;
        return (int) Math.round(tax);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d %d %d", id, numImport, getNumExport(), getUnitPrice(), getMoney(), getTax());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Goods> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Goods good = new Goods(sc.next(),sc.nextInt());
            list.add(good);
        }
        Collections.sort(list, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if(o1.getTax() > o2.getTax()) return -1;
                return 1;
            }
        });
        String q = sc.next();
        for(Goods good: list){
            if(good.getId().charAt(0) == q.charAt(0)){
                System.out.println(good);
            }
        }
    }
}