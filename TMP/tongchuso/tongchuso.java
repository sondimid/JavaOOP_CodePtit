package tongchuso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.util.ArrayList;

public class tongchuso {
    public static void main(String[] args) throws Exception {
        ObjectInputStream file = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> list = (ArrayList<String>) file.readObject();
        for(String str : list){
            String s = "";
            int res = 0;
            for(int i = 0; i < str.length(); i++){
                if(Character.isDigit(str.charAt(i))){
                    s += str.charAt(i);
                    res += (str.charAt(i) - '0');
                }
            }
            System.out.println(new BigInteger(s) + " " + res);
        }
    }
}