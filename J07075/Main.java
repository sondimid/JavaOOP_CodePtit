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
    private Subject subject;
    public Lop(int idGroup, String idSubject, int day, int section, String nameTeacher, String room) {
        this.idGroup += String.format("%03d", idGroup);
        this.idSubject = idSubject;
        this.day = day;
        this.section = section;
        this.nameTeacher = nameTeacher;
        this.room = room;
    }

    public void setSubject(Subject subject){
        this.subject = subject;
    }
    public String getIdSubject() {
        return idSubject;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %s", idGroup, subject.getName(), day, section, room);
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
            Lop lop = new Lop(i, sc1.nextLine(),Integer.parseInt(sc1.nextLine()), Integer.parseInt(sc1.nextLine()), sc1.nextLine(), sc1.nextLine());
            lop.setSubject(map.get(lop.getIdSubject()));
            list.add(lop);
        }
        Collections.sort(list);
        String nameTeacher = sc1.nextLine();
        System.out.println("LICH GIANG DAY GIANG VIEN " + nameTeacher + ":");
        for(Lop lop : list){
            if(lop.getNameTeacher().equals(nameTeacher)) System.out.println(lop);
        }
    }
}