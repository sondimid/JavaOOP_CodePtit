import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;


class Province{
    private String id="", name="";
    private int unitPrice;

    public Province(String id, String name, int unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public Province() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}

class Call{
    private String phoneNum;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    private Date start, end;
    private long minute;
    private Province province = new Province();

    public Call(String phoneNum, String start, String end) {
        this.phoneNum = phoneNum;
        try {
            this.end = sdf.parse(end);
            this.start = sdf.parse(start);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        this.minute = (this.end.getTime() - this.start.getTime()) /(1000*60);

    }

    public String getIdPhone() {
        return phoneNum.substring(1,3);
    }

    public void setProvince(){
        this.minute = (int) Math.ceil(this.minute / 3.0);
        this.province.setName("Noi mang");
        this.province.setUnitPrice(800);
    }

    public void setProvince(Province province){
        this.province = province;
    }

    public long getCost(){
        return province.getUnitPrice() * minute;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", phoneNum, province.getName(), minute, getCost());
    }

}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Province> provinceList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            provinceList.add(new Province(id, name, sc.nextInt()));
        }
        ArrayList<Call> list = new ArrayList<>();
        n = sc.nextInt();
        for(int i = 0 ;i < n; i++){
            Call call = new Call(sc.next(), sc.next(), sc.next());
            if(call.getPhoneNum().charAt(0) == '0'){
                for(Province province : provinceList){
                    if(call.getIdPhone().equals(province.getId())){
                        call.setProvince(province);
                        break;
                    }
                }
            }
            else{
                call.setProvince();
            }
            list.add(call);
        }
        for(Call call : list){
            System.out.println(call);
        }
    }
}