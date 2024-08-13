import java.util.*;
import java.io.*;
class Student{
    private String name;
    private int correctSub,sub;

    public Student(String name, int correctSub, int sub) {
        this.name = name;
        this.correctSub = correctSub;
        this.sub = sub;
    }

    public String getName() {
        return name;
    }

    public int getCorrectSub() {
        return correctSub;
    }

    public int getSub() {
        return sub;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, correctSub, sub);
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(new Student(sc.nextLine(), sc.nextInt(), sc.nextInt()));
            sc.nextLine();
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getCorrectSub() == o2.getCorrectSub()){
                    if(o1.getSub() == o2.getCorrectSub()){
                        return o1.getName().compareTo(o2.getName());
                    }
                    if(o1.getSub() < o2.getSub()) return -1;
                    return 1;
                }
                if(o1.getCorrectSub() > o2.getCorrectSub()) return -1;
                return 1;
            }
        });
        for(Student student : list){
            System.out.println(student);
        }
    }
}