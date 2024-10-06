package cau10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Comparable<Student>{
    private String name;
    private Date start, end;

    public Student(String name, String start, String end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.name = name;
        this.start = sdf.parse(start);
        this.end = sdf.parse(end);
    }

    public long getDuration() {
        return (end.getTime() - start.getTime())/(1000*60);
    }

    @Override
    public int compareTo(Student o) {
        if(this.getDuration() != o.getDuration()) return -Long.compare(this.getDuration(), o.getDuration());
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("%s %d", name,getDuration());
    }
}
