import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Person implements Comparable<Person>{
    private String name, birth, id = "VDV";
    private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    private Date start, end;
    private int rank;

    public int getAge(){
        return 2021 - Integer.parseInt(birth.substring(birth.length()-4));
    }

    public String formatTime(long second){
        second /= 1000;
        long h = second / 3600;
        long m = (second - h * 3600) / 60;
        long s = second - h * 3600 - m * 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public long getResult(){
        return this.end.getTime() - this.start.getTime();
    }

    public long getPriority(){
        if(getAge() < 18) return 0;
        else if(getAge() < 25) return 1000;
        else if(getAge() < 32) return 2000;
        else return 3000;
    }

    public long getFinal(){
        return getResult() - getPriority();
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public Person(String name, String birth, String start, String end, int id) {
        if(id < 10) this.id +='0';
        this.id += Integer.toString(id);
        this.name = name;
        this.birth = birth;
        try {
            this.start = sdf.parse(start);
            this.end = sdf.parse(end);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %d", id, name, formatTime(getResult()), formatTime(getPriority()), formatTime(getFinal()), getRank());
    }

    @Override
    public int compareTo(Person o) {
        return Long.compare(this.getFinal(), o.getFinal());
    }

}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Person> list = new ArrayList<>();
        ArrayList<Person> newList = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Person person = new Person(sc.nextLine(), sc.next(), sc.next(), sc.next(), i);
            list.add(person);
            newList.add(person);
        }
        Collections.sort(list);
        int rank = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(newList.get(i).getFinal() == list.get(j).getFinal()){
                    newList.get(i).setRank(j+1);
                    break;
                }
            }
        }
        Collections.sort(newList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getRank(), o2.getRank());
            }
        });
        for(Person person : newList){
            System.out.println(person);
        }
    }
}