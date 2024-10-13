package soKhacNhauTrongFileNhiPhan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeSet;

public class soKhacNhauTrongFileNhiPhan {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream file = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> list = (ArrayList<String>) file.readObject();
        TreeSet<Integer> res = new TreeSet<>();
        for(String s : list){
            String[] split = s.split("\\s+");
            for(String str : split){
                if(Utils.check(str)){
                    res.add(Integer.parseInt(str));
                }
            }
        }
        for(Integer i : res){
            System.out.println(i);
        }
    }
}
