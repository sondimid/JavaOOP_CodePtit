import java.util.*;
import java.io.*;

class Invoice{
    private String customerType,id = "KH";
    private int numElec;

    public Invoice(String customerType,int startIdx, int endIdx,int id) {
        this.customerType = customerType;
        this.numElec = endIdx - startIdx;
        if(id < 10) this.id += "0";
        this.id += Integer.toString(id);
    }
    public int getCoefficent(){
        if(customerType.equals("KD")) return 3;
        if(customerType.equals("NN")) return 5;
        if(customerType.equals("TT")) return 4;
        if(customerType.equals("CN")) return 2;
        return 0;
    }
    public int getTotal(){
        return numElec * getCoefficent() * 550;
    }
    public int getExtra(){
        int extra;
        if(numElec < 50 ) extra = 0;
        else if(numElec <= 100) extra = Math.round(getTotal() * 0.35f);
        else extra = getTotal();
        return extra;
    }
    public int getTotalPay(){
        return getExtra() + getTotal();
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d %d", id, getCoefficent(), getTotal(), getExtra(), getTotalPay());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Invoice> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(new Invoice(sc.next(), sc.nextInt(), sc.nextInt(), i));
        }
        for(Invoice invoice : list){
            System.out.println(invoice);
        }
    }
}