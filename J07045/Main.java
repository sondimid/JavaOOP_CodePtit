import java.util.*;
import java.io.*;

class LoaiPhong implements Comparable<LoaiPhong>{
    private String id, type;
    private int unitPrice;
    private double serviceFee;

    public LoaiPhong(String s){
        String[] tmp = s.trim().split("\\s+");
        this.id = tmp[0];
        this.type = tmp[1];
        this.unitPrice = Integer.parseInt(tmp[2]);
        this.serviceFee = Double.parseDouble(tmp[3]);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %.2f", id, type, unitPrice, serviceFee);
    }

    @Override
    public int compareTo(LoaiPhong o) {
        return this.type.compareTo(o.type);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}