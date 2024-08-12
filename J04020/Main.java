import java.util.*;
public class Main{
    public static boolean Prime(int n){
        if(n<2) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    static class Pair<I extends Number, I1 extends Number> {
        private I a;
        private I1 b;
        public Pair(I i, I1 i1) {
            this.a = i;
            this.b = i1;
        }
        public boolean isPrime(){
            return Prime((Integer) a) && Prime((Integer) b);
        }

        @Override
        public String toString() {
            String format = String.format(this.a + " " + this.b);
            return format;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
