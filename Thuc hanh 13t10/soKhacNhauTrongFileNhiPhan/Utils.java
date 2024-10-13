package soKhacNhauTrongFileNhiPhan;

public class Utils {
    public static boolean check(String s){
        try{
            Integer val = Integer.parseInt(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
