//public class Staff {
//    private String id,name;
//    private int salary,cnt;
//
//    public Staff(String name, int salary, int cnt, String id) {
//        this.id="NV01";
//        this.name = name;
//        this.salary = salary;
//        this.cnt = cnt;
//        this.id = id;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getSalary() {
//        return salary;
//    }
//
//    public int getCnt() {
//        return cnt;
//    }
//    public void print(){
//        int bonus;
//        int salaryM = this.salary*this.cnt;
//        if(this.cnt<22) bonus=0;
//        else if(this.cnt<25) bonus = (int) (0.1*salaryM);
//        else bonus = (int) (0.2 * salaryM);
//        int phuCap = 0;
//        if(this.id.charAt(0) == 'G') phuCap = 250000;
//        if(this.id.charAt(0) == 'P') phuCap = 200000;
//        if(this.id.charAt(0) == 'T') phuCap = 180000;
//        if(this.id.charAt(0) == 'N') phuCap = 150000;
//        int income = this.salary*this.cnt + bonus + phuCap;
//        System.out.println(this.id+" "+this.name+" "+salaryM+" "+bonus+" "+phuCap+" "+income);
//    }
//}