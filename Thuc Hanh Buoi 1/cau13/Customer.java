package cau13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Customer implements Comparable<Customer>{
    private String id, name, address, idProduct;
    private int quantity;
    private Date time;
    private Product product;

    public Customer(int id, String name, String address, String idProduct, int quantity, String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.id = String.format("KH%02d", id);
        this.name = name;
        this.address = address;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.time = sdf.parse(time);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getHetHan(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.MONTH, product.getWarranty());
        return calendar.getTime();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int compareTo(Customer o) {
        if(!this.getHetHan().equals(o.getHetHan())){
            return this.getHetHan().compareTo(o.getHetHan());
        }
        return this.getId().compareTo(o.getId());
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%s %s %s %s %d %s", id, name, address, idProduct, quantity * product.getPrice(), sdf.format(getHetHan()));
    }
}
