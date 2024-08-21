import java.util.*;
import java.io.*;

class Company implements Comparable<Company>{
    private String id, name;
    private int num;

    public Company(String id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", id, name, num);
    }

    @Override
    public int compareTo(Company o) {
        return this.id.compareTo(o.id);
    }
}
public class Main {
    public static void main(String[] arg) {
        try {
            Scanner sc = new Scanner(new File("DN.in"));
            int n = sc.nextInt();
            ArrayList<Company> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String id = sc.next();
                sc.nextLine();
                String name = sc.nextLine();
                list.add(new Company(id, name, sc.nextInt()));
            }
            Collections.sort(list);
            for(Company company : list) System.out.println(company);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}