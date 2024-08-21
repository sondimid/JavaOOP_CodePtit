import java.util.*;
import java.io.*;

class Teacher implements Comparable<Teacher>{
    private String name, id, numOrder = "GV";
    private double score1, score2;
    public static HashMap<Character, String> mp = new HashMap<>();

    public Teacher(String name, String id, double score1, double score2, int numOrder) {
        mp.put('A', "TOAN");
        mp.put('B', "LY");
        mp.put('C', "HOA");
        this.name = name;
        this.id = id;
        this.score1 = score1;
        this.score2 = score2;
        if (numOrder < 10) this.numOrder += "0";
        this.numOrder += Integer.toString(numOrder);
    }

    public String getSubject(){
        return mp.get(id.charAt(0));
    }

    public double getPriority(){
        if(id.charAt(1) == '1') return 2.0;
        else if(id.charAt(1) == '2') return 1.5;
        else if(id.charAt(1) == '3') return 1;
        else return 0;
    }

    public double getScore(){
        return score1 * 2 + score2 +getPriority();
    }

    public String getStatus(){
        if(getScore() >= 18) return "TRUNG TUYEN";
        return "LOAI";
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.1f %s", numOrder, name, getSubject(), getScore(), getStatus());
    }

    @Override
    public int compareTo(Teacher o) {
        return -Double.compare(this.getScore(), o.getScore());
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Teacher> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            list.add(new Teacher(sc.nextLine(), sc.next(), sc.nextDouble(), sc.nextDouble(), i));
        }
        Collections.sort(list);
        for(Teacher teacher : list){
            System.out.println(teacher);
        }
    }
}