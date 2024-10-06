
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i ==0 ) return false;
        }
        return n > 1;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream file1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream file2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        Set<Integer> list1 = new TreeSet<>((ArrayList)file1.readObject());
        Set<Integer> list2 = new TreeSet<>((ArrayList)file2.readObject());

        for(Integer value : list1){
            if(isPrime(value) && list2.contains(1000000-value) && isPrime(1000000-value) && value < 1000000-value){
                System.out.println(value + " " + (1000000-value));
            }
        }
    }
}
