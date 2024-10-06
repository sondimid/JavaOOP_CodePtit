package J07025;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer implements Comparable<Customer>{
    private String id, name, gender, address;
    private Date dob;
    public Customer(int id, String name, String gender, String dob, String address) throws ParseException {
        this.id = String.format("KH%03d", id);
        this.gender = gender;
        this.address = address;
        String[] s = name.trim().toLowerCase().split("\\s+");
        this.name = "";
        for(String value : s){
            this.name += Character.toUpperCase(value.charAt(0)) + value.substring(1) + " ";
        }
        StringBuilder sb = new StringBuilder(dob);
        if(sb.charAt(2) != '/') sb.insert(0, '0');
        if(sb.charAt(5) != '/') sb.insert(3, '0');
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.dob = sdf.parse(sb.toString());
    }

    @Override
    public int compareTo(Customer o) {
        return this.dob.compareTo(o.dob);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%s %s%s %s %s", id, name, gender, address, sdf.format(dob));
    }
}
