package cau9;

public class Student implements Comparable<Student>{
    private String name;
    private int ok, submit;

    public Student(String name, int ok, int submit) {
        this.name = name;
        this.ok = ok;
        this.submit = submit;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, ok, submit);
    }

    @Override
    public int compareTo(Student o) {
        if(this.ok != o.ok) return -Integer.compare(this.ok, o.ok);
        if(this.submit != o.submit) return Integer.compare(this.submit, o.submit);
        return this.name.compareTo(o.name);
    }
}
