public class GV {
    private String ma,ten;
    private long luong,heSo,phuCap,salary;

    public GV(String ma, String ten, long luong) {
        this.ma = ma;
        this.ten = ten;
        this.luong = luong;
    }
    public void salary() {

        String code = this.ma.substring(0, 2);

        long phuCap;

        if (code.equals("HT")) {
            phuCap = 2000000;
        } else if (code.equals("HP")) {
            phuCap = 900000;
        } else {
            phuCap = 500000;
        }

        long heSo = (this.ma.charAt(2) - '0') * 10 + (this.ma.charAt(3) - '0');


        this.heSo = heSo;
        this.phuCap = phuCap;

        this.salary = this.luong * heSo + phuCap;
    }

    public long getSalary() {
        return salary;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public long getLuong() {
        return luong;
    }

    public long getHeSo() {
        return heSo;
    }

    public long getPhuCap() {
        return phuCap;
    }
}
