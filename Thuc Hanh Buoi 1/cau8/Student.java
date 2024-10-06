package cau8;

public class Student implements Comparable<Student>{
    private String id, name, lop, email, phoneNum="0";

    public Student(String id, String name, String lop, String email, String phoneNum) {
        this.id = id;
        this.name = name;
        this.lop = lop;
        this.email = email;
        this.phoneNum += phoneNum;
    }

    @Override
    public int compareTo(Student o) {
        if(this.lop.equals(o.lop))
            return this.id.compareTo(o.id);
        return this.lop.compareTo(o.lop);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", id, name, lop, email, phoneNum);
    }
}
