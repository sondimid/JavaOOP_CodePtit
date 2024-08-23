import java.util.*;


class Student  {
    private String iD;
    private String fullName;
    private String classId;
    private String email;

    public Student(String iD, String fullName, String classId, String email) {
        this.iD = iD;
        this.fullName = fullName;
        this.classId = classId;
        this.email = email;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    @Override
    public String toString() {
        return iD + " " + fullName + " " + classId + " " + email;
    }


}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        ArrayList<Student> ds = new ArrayList<>();
        while (t-- > 0) {
            ds.add(new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            String s = sc.nextLine();

            System.out.println("DANH SACH SINH VIEN NGANH " + s.toUpperCase() + ":");
            if (s .equals("Ke toan")) s = "DCKT";
            else if (s.equals("Cong nghe thong tin")) s = "DCCN";
            else if (s.equals("An toan thong tin")) {
                s = "DCAT";
            } else if (s.equals("Vien thong")) {
                s = "DCVT";
            } else {
                s = "DCDT";
            }

            for (int i = 0; i < ds.size(); i++) {
                if (ds.get(i).getiD().contains(s) && s .equals("DCCN") && !ds.get(i).getClassId().startsWith("E")) {
                    System.out.println(ds.get(i));
                } else if (ds.get(i).getiD().contains(s) && s .equals("DCAT") && !ds.get(i).getClassId().startsWith("E")) {
                    System.out.println(ds.get(i));
                } else if (ds.get(i).getiD().contains(s)) {
                    System.out.println(ds.get(i));
                }
            }
        }
    }
}