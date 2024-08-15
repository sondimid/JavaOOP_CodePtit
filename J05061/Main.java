import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

class Person implements Comparable<Person>{
    private String name, birth, id="PH";
    private double score1, score2;

    public Person(String name, String birth, double score1, double score2, int id) {
        this.name = name;
        this.birth = birth;
        this.score1 = score1;
        this.score2 = score2;
        if(id < 10) this.id += '0';
        this.id += Integer.toString(id);
    }
    public int getScore(){
        double bonus = 0;
        if(score1 >= 8 && score2 >= 8) bonus = 1;
        else if(score1 >= 7.5 && score2 >= 7.5) bonus = 0.5;
        double score = (score1 + score2) * 0.5 +bonus;
        if(score > 10) return 10;
        return (int)Math.round(score);
    }
    public int getAge(){
        return 2021 - Integer.parseInt(birth.substring(birth.length()-4));
    }
    public String getLevel(){
        if(getScore() >= 9 ) return "Xuat sac";
        if(getScore() == 8) return "Gioi";
        if(getScore() == 7) return "Kha";
        if(getScore() >= 5) return "Trung binh";
        return "Truot";
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %s", id, name, getAge(), getScore(), getLevel());
    }

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(Person o) {
        if(this.getScore() == o.getScore()){
            return this.getId().compareTo(o.getId());
        }
        return o.getScore() - this.getScore();
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Person> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            list.add(new Person(sc.nextLine(), sc.next(), sc.nextDouble(), sc.nextDouble(), i));
        }
        Collections.sort(list);
        for(Person person : list){
            System.out.println(person);
        }
    }
}