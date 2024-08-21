import java.util.*;
import java.io.*;

class Person implements Comparable<Person>{
    private String name = "", firstName, lastName, midName = "";

    public Person(String name) {
        String[] s = name.trim().toLowerCase().split("\\s+");
        for(int i = 0; i < s.length; i++){
            this.name += Character.toUpperCase(s[i].charAt(0)) + s[i].substring(1) + " ";
        }

        for(int i = 1 ; i < s.length -1 ; i++){
            this.midName += Character.toUpperCase(s[i].charAt(0)) + s[i].substring(1) + " ";
        }
        this.firstName = Character.toUpperCase(s[s.length -1].charAt(0)) + s[s.length - 1].substring(1) ;
        this.lastName = Character.toUpperCase(s[0].charAt(0)) + s[0].substring(1);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        if(this.firstName.equals(o.firstName)){
            if(this.lastName.equals(o.lastName)) return this.midName.compareTo(o.midName);
            return this.lastName.compareTo(o.lastName);
        }
        return this.firstName.compareTo(o.firstName);
    }

}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        ArrayList<Person> list = new ArrayList<>();
        while(sc.hasNextLine()){
            list.add(new Person(sc.nextLine()));
        }
        Collections.sort(list);
        for(Person person : list) System.out.println(person);
    }
}