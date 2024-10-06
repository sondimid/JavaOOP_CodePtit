package J07016;

public class Utils {
    public static boolean isPrime(Integer value){
        StringBuilder sb = new StringBuilder(value.toString());
        for(int i = 2; i <= Math.sqrt(value); i++){
            if(value % i == 0) return false;
        }
        return value > 1 && value.toString().contentEquals(sb.reverse());
    }
}
