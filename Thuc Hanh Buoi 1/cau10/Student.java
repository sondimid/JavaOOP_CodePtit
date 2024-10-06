package cau10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String name;
    private Date start, end;

    public Student(String name, String start, String end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.name = name;
        this.start = sdf.parse(start);
        this.end = sdf.parse(end);
    }

    public long getDuration() {
        return end.getTime() - start.getTime();
    }
}
