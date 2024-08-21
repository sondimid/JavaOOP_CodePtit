import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
    private String name = "", id = "SV";
    private double score;
    private int order=0;

    public Student(String name, int id, double score1, double score2, double score3) {
        String[] s = name.trim().toLowerCase().split("\\s+");
        for(int i = 0; i < s.length; i++){
            this.name += Character.toUpperCase(s[i].charAt(0)) + s[i].substring(1) + " ";
        }
        if(id < 10) this.id +='0';
        this.id +=Integer.toString(id);
        this.score = (score1*3 + score2*3 + score3*2) / 8;
        this.score = Math.round(this.score * 100.0) / 100.0;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("%s %s%.2f %d", id, name, score, order);
    }

    @Override
    public int compareTo(Student o) {
        if(this.score == o.score) return this.id.compareTo(o.id);
        return -Double.compare(this.score, o.score);
    }
}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            list.add(new Student(sc.nextLine(), i, sc.nextDouble(), sc.nextDouble(), sc.nextDouble()));
        }
        Collections.sort(list);
        int order = 1;
        for(int i = 0; i < n; i++){
            if(list.get(i).getOrder() == 0){
                list.get(i).setOrder(order);
                order ++;
                for(int j = i+1; j < n; j++){
                    if(list.get(i).getScore() == list.get(j).getScore()){
                        list.get(j).setOrder(list.get(i).getOrder());
                        order ++;
                    }
                }
            }
        }
        for(Student student : list){
            System.out.println(student);
        }
    }
}