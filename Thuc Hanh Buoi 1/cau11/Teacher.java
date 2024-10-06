package cau11;

public class Teacher {
    private String id,name, project;
    public Teacher(int id,String name, String project) {
        this.id = String.format("DT%03d", id);
        this.name = name;
        this.project = project;
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
