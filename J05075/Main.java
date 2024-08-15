import java.util.*;
import java.io.*;

class Student{
    private String id, name, lop, status = "KDDK";
    private int score;

    public Student(String id, String name, String lop) {
        this.id = id;
        this.name = name;
        this.lop = lop;
    }

    public String getId() {
        return id;
    }

    public String getLop() {
        return lop;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        if(score == 0) return String.format("%s %s %s %d %s", id, name, lop, score, status);
        return String.format("%s %s %s %d", id, name, lop, score);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Student> list= new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String lop = sc.next();
            list.add(new Student(id, name, lop));
        }
        sc.nextLine();
        for(int i = 0; i < n; i++){
            String[] s = sc.nextLine().split("\\s+");
            String id = s[0];
            String code = s[1];
            for(int j = 0; j < list.size(); j++){
                if(list.get(j).getId().equals(id)){
                    int sum = 10;
                    for(int l = 0; l < code.length(); l++){
                        if(code.charAt(l) == 'v') sum -= 2;
                        if(code.charAt(l) == 'm') sum -= 1;
                    }
                    list.get(j).setScore(Math.max(0,sum));
                    break;
                }
            }
        }
        String lop = sc.next();
        for(Student student : list){
            if(student.getLop().equals(lop)) System.out.println(student);
        }
    }
}