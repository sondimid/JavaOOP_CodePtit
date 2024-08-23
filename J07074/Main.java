import java.util.*;
import java.io.*;

class Subject{
    private String id, name;
    private int num;

    public Subject(String id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Lop implements Comparable<Lop>{
    private String idGroup = "HP", idSubject, nameTeacher, room;
    private int  day, section;

    public Lop(int idGroup, String idSubject, int day, int section, String nameTeacher, String room) {
        this.idGroup += String.format("%03d", idGroup);
        this.idSubject = idSubject;
        this.day = day;
        this.section = section;
        this.nameTeacher = nameTeacher;
        this.room = room;
    }

    public String getIdSubject() {
        return idSubject;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %s %s", idGroup, day, section, nameTeacher, room);
    }

    @Override
    public int compareTo(Lop o) {
        if(this.day == o.day){
            if(this.section == o.section) return this.nameTeacher.compareTo(o.nameTeacher);
            return Integer.compare(this.section, o.section);
        }
        return Integer.compare(this.day, o.day);
    }

}
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = sc.nextInt();
        HashMap<String, Subject> map = new HashMap<>();
        sc.nextLine();
        for(int i = 0; i < n; i++){
            Subject subject = new Subject(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
            map.put(subject.getId(), subject);
        }
        Scanner sc1 = new Scanner(new File("LICHGD.in"));
        n = sc1.nextInt();
        ArrayList<Lop> list = new ArrayList<>();
        sc1.nextLine();
        for(int  i = 1;i <= n; i++){
            list.add(new Lop(i, sc1.nextLine(),Integer.parseInt(sc1.nextLine()), Integer.parseInt(sc1.nextLine()), sc1.nextLine(), sc1.nextLine()));
        }
        Collections.sort(list);
        String idSubject = sc1.nextLine();
        System.out.println("LICH GIANG DAY MON " + map.get(idSubject).getName() + ":");
        for(Lop lop : list){
            if(lop.getIdSubject().equals(idSubject)) System.out.println(lop);
        }
    }
}