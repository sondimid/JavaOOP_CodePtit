import java.util.*;
import java.io.*;

class Invoice implements Comparable<Invoice>{
    private String name = "", id = "KH";
    private char type;
    private int num;

    public Invoice(String name, char type, int start, int end, int id) {
        String[] s = name.trim().toLowerCase().split("\\s+");
        for(int i = 0; i < s.length; i++) this.name += Character.toUpperCase(s[i].charAt(0)) + s[i].substring(1) + " ";
        this.id += String.format("%02d", id);
        this.type = type;
        this.num = end - start;
    }

    public int getStandard(){
        if(type == 'A') return 100;
        if(type == 'B') return 500;
        return 200;
    }

    public int getCost1(){
        if(num <= getStandard()) return num * 450;
        return getStandard() * 450;
    }

    public int getCost2(){
        if(num > getStandard()) return (num - getStandard()) * 1000;
        return 0;
    }

    public int getVATCost(){
        return (int) ((int) getCost2() * 0.05);
    }

    public int getTotalCost(){
        return getCost1() + getCost2() + getVATCost();
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", id, name, getCost1(), getCost2(), getVATCost(), getTotalCost());
    }

    @Override
    public int compareTo(Invoice o) {
        return Integer.compare(o.getTotalCost(), this.getTotalCost());
    }
}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = sc.nextInt();
        ArrayList<Invoice> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            list.add(new Invoice(sc.nextLine(), sc.next().charAt(0), sc.nextInt(), sc.nextInt(), i));
        }
        Collections.sort(list);
        for(Invoice invoice : list) System.out.println(invoice);
    }
}