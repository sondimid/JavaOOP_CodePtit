import java.util.*;
import java.io.*;
class Student{
    private String name, level, id = "HS";
    private double score;
    private int ratting;

    public Student(String name, double score,int id) {
        this.name = name;
        this.score = score;
        if(score < 5) this.level = "Yeu";
        else if(score < 7) this.level = "Trung Binh";
        else if(score < 9) this.level = "Kha";
        else this.level = "Gioi";
        if(id < 10) this.id += '0';
        this.id += Integer.toString(id);

    }

    public String getId() {
        return id;
    }

    public void setRating(int ratting){
        this.ratting = ratting;
    }

    public double getScore() {
        return score;
    }

    public int getRatting() {
        return ratting;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f %s %d", id, name, score, level, ratting);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            list.add(new Student(sc.nextLine(), sc.nextDouble(), i));
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getScore() > o2.getScore()) return -1;
                return 1;
            }
        });
        int cnt = 1;
        for(int i = 0; i < list.size(); i++){
            int j = i+1;
            list.get(i).setRating(cnt);
            while(j < list.size() && list.get(i).getScore() == list.get(j).getScore()){
                list.get(j).setRating(list.get(i).getRatting());
                j++;
                cnt++;
            }
            cnt++;
            i = j-1;
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        for(Student student : list){
            System.out.println(student);
        }
    }
}