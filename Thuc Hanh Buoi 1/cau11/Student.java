package cau11;

public class Student implements Comparable<Student>{
    private String id, name, phoneNum, email;
    private Teacher teacher;
    public Student(String id, String name, String phoneNum, String email) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", id, name, teacher.getProject(), teacher.getName());
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }
}
