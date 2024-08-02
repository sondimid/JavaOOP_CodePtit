public class SV {
    private String name;
    private String dob;
    private double gpa;
    private String msv="SV001";
    private String lop;

    public SV(String name,String lop, String dob, double gpa) {
        this.lop=lop;
        this.name = name;
        this.gpa=gpa;
        this.dob=dob;
        String[] a = this.dob.split("/");
        this.dob = "";
        while(a[0].length() < 2)
            a[0] = "0" + a[0];
        this.dob += a[0] + "/";
        while(a[1].length() < 2)
            a[1] = "0" + a[1];
        this.dob += a[1] + "/";
        while(a[2].length() < 4)
            a[2] = "0" + a[2];
        this.dob += a[2];
    }
    public void print() {
        System.out.print(name +" "+lop+ " " + dob + " ");
        System.out.printf("%.2f", gpa);
    }
}