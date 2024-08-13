import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.time.*;
class Person{
    private String name;
    private Date birth;
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Person(String name, String birth) {
        this.name = name;
        try{
            this.birth = dateFormat.parse(birth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Person> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new Person(sc.next(), sc.next()));
        }
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getBirth().compareTo(o2.getBirth());
            }
        });
        System.out.println(list.get(n-1));
        System.out.println(list.get(0));
    }
}