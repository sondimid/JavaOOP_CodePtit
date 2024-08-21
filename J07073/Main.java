import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Subject implements Comparable<Subject>{
    private String id, name, format1, format2;
    private int num;

    public Subject(String id, String name, int num, String format1, String format2) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.format1 = format1;
        this.format2 = format2;
    }

    public boolean format(){
        if(!format2.equals("Truc tiep")) return true;
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %s %s", id, name, num, format1, format2);
    }

    @Override
    public int compareTo(Subject o) {
        return this.id.compareTo(o.id);
    }
}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = sc.nextInt();
        ArrayList<Subject> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int num = sc.nextInt();
            sc.nextLine();
            String format1 = sc.nextLine();
            String format2 = sc.nextLine();
            list.add(new Subject(id, name, num, format1, format2));
        }
        Collections.sort(list);
        for(Subject subject : list){
            if(subject.format()) System.out.println(subject);
        }
    }
}