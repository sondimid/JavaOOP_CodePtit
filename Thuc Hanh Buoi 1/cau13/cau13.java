package cau13;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class cau13 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        int n = sc.nextInt();
        ArrayList<Product> products = new ArrayList<Product>();
        for(int i = 0; i < n; i++){
            sc.nextLine();
            products.add(new Product(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        ArrayList<Customer> customers = new ArrayList<Customer>();
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            sc.nextLine();
            customers.add(new Customer(i+1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.next()));
        }
        for(Customer customer : customers){
            for(Product product : products){
                if(customer.getIdProduct().equals(product.getId())){
                    customer.setProduct(product);
                    break;
                }
            }
        }
        Collections.sort(customers);
        for(Customer customer : customers){
            System.out.println(customer);
        }
    }
}
