import java.util.*;
import java.io.*;
class Invoice implements Comparable<Invoice>{
    private String id ="KH", name;
    private int start, end;

    public Invoice(int id, String name, int start, int end) {
        if(id < 10) this.id +='0';
        this.id += Integer.toString(id);
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public int getTotal(){
        int consume = end - start;
        int total = 0;
        for(int i = 1; i <= consume; i++){
            if(i <= 50) total +=100;
            else if(i <= 100) total +=150;
            else total +=200;
        }
        if(consume <= 50) return (int)Math.round(total * 1.02f);
        else if (consume <= 100) return (int)Math.round(total * 1.03f);
        else return (int)Math.round(total * 1.05f);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d",id, name, getTotal());
    }

    @Override
    public int compareTo(Invoice o) {
        return -Integer.compare(this.getTotal(), o.getTotal());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Invoice> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            list.add(new Invoice(i, sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);
        for(Invoice invoice: list){
            System.out.println(invoice);
        }

    }
}