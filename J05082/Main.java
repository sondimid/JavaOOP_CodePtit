import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Customer implements Comparable<Customer>{
    private String id="KH0", name="", gender, birth, address;
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Customer(int id, String name, String gender, String birth, String address) {
        if(id < 10) this.id += '0';
        this.id += Integer.toString(id);
        String[] s = name.trim().split("\\s+");
        for(int i = 0; i < s.length; i++){
            StringBuilder sb = new StringBuilder(s[i].toLowerCase());
            sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
            this.name += sb.toString() + " ";
        }
        this.gender = gender;
        StringBuilder sb = new StringBuilder(birth);
        if(sb.charAt(2) != '/') sb.insert(0,'0');
        if(sb.charAt(5) != '/') sb.insert(3,'0');
        this.birth = sb.toString();
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s %s%s %s %s", id, name, gender, address, birth);
    }

    @Override
    public int compareTo(Customer o) {
        Date o1 = null;
        try {
            o1 = sdf.parse(this.birth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date o2 = null;
        try {
            o2 = sdf.parse(o.birth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return o1.compareTo(o2);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Customer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String name = sc.nextLine();
            String gender = sc.next();
            String birth = sc.next();
            sc.nextLine();
            String address = sc.nextLine();
            list.add(new Customer(i+1, name, gender, birth, address));
        }
        Collections.sort(list);
        for(Customer customer :list){
            System.out.println(customer);
        }
    }
}