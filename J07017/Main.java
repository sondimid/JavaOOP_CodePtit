import java.util.*;
import java.io.*;

class Pair<Interger, Integer>{
    private int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    public boolean isPrime(){
        if (first < 2 || second < 2) return false;
        for(int i = 2;i <= Math.sqrt(first); i++){
            if(first % i == 0) return false;
        }
        for(int i = 2;i <= Math.sqrt(second); i++){
            if(second % i == 0) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%d %d", first, second);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break;
                }
            }
            if(!check) System.out.println(-1);
        }
    }
}