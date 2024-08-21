import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

class Person{
    private String name, birth, id = "PH";
    private double score;
//    private DecimalFormat df =  new DecimalFormat();

    public Person(String name, String birth, double score1, double score2, int id) {
        this.name = "";
        StringBuilder sb = new StringBuilder(birth);
        if(sb.charAt(2) != '/') sb.insert(0,'0');
        if(sb.charAt(5) != '/') sb.insert(3,'0');
        this.birth = sb.toString();
        if(id < 10) this.id +='0';
        this.id +=Integer.toString(id);
        String[] s = name.trim().toLowerCase().split("\\s+");
        for(int i = 0; i < s.length; i++) {
            this.name += Character.toUpperCase(s[i].charAt(0)) + s[i].substring(1) + " ";
        }
        this.score = (score1 + score2) / 2.0;
        if(score1 >= 8 && score2 >= 8) this.score +=1;
        else if(score1 >= 7.5 && score2 >= 7.5) this.score +=0.5;
        this.score = Math.min(this.score, 10);
        this.score = Math.round(this.score);
    }

    public int getAge(){
        return 2021 - Integer.parseInt(birth.substring(birth.length() - 4));
    }
    public String getStatus(){
        if(score >= 9) return "Xuat sac";
        if(score == 8) return "Gioi";
        if(score == 7) return "Kha";
        if(score >= 5) return "Trung binh";
        return "Truot";
    }

    @Override
    public String toString() {
        return String.format("%s %s%d %d %s", id, name, getAge(), (int)score, getStatus());
    }
}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        int n = sc.nextInt();
        ArrayList<Person> list = new ArrayList<>();
        for(int i = 1; i <=n; i++){
            sc.nextLine();
            list.add(new Person(sc.nextLine(), sc.next(), sc.nextDouble(), sc.nextDouble(), i));
        }
        for(Person person : list) System.out.println(person);
    }
}