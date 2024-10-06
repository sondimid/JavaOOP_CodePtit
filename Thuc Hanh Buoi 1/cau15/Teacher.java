package cau15;

public class Teacher {
    private String id, name;
    private double time = 0;

    public Teacher(String id, String name) {
        this.id = id;
        this.name = name;
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

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time += time;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", name, time);
    }
}
