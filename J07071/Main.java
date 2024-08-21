import java.util.*;
import java.io.*;

class Person implements Comparable<Person>{
    private String name, id = "", firstName, lastName;

    public Person(String name) {
        this.name = name;
        String[] s = name.trim().split("\\s+");
        for(int i = 0 ; i < s.length; i++){
            this.id += s[i].charAt(0);
        }
        this.firstName = s[s.length-1];
        this.lastName = s[0];
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        if(this.firstName.equals(o.firstName)) return this.lastName.compareTo(o.lastName);
        return this.firstName.compareTo(o.firstName);
    }

}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        int n = sc.nextInt();
        ArrayList<Person> list = new ArrayList<>();
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            list.add(new Person(sc.nextLine()));
        }
        Collections.sort(list);
        int q = sc.nextInt();
        while(q-->0){
            String id = sc.next().replaceAll("\\.","");
            for(Person person : list){
                boolean check = true;
                if(person.getId().length() != id.length()) check = false;
                if(check){
                    for(int i = 0; i < id.length(); i++){
                        if(id.charAt(i) == '*') continue;
                        if(id.charAt(i) != person.getId().charAt(i)) check = false;
                    }
                    if(check) System.out.println(person);
                }
            }
        }
    }
}