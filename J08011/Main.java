
import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    String s;
    int fre;
    int order;

    public Pair(String s, int order) {
        this.s = s;
        this.fre = 1;
        this.order = order;
    }

    @Override
    public String toString() {
        return String.format("%s %d", s, fre);
    }

    @Override
    public int compareTo(Pair o) {
        if(this.fre == o.fre) return Integer.compare(this.order, o.order);
        return -Integer.compare(this.fre, o.fre);
    }
}
public class Main {
    public static boolean check(String s){
        for(int i = 0 ; i < s.length() - 1; i++){
            if(s.charAt(i) > s.charAt(i+1)) return false;
        }
        return true;
    }
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pair> list = new ArrayList<>();
        int cnt = 0;
        while(sc.hasNext()){
            String s = sc.next();
            boolean test = true;
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).s.equals(s)) {
                    test = false;
                    list.get(i).fre +=1;
                    break;
                }
            }
            if(test){
                list.add(new Pair(s, cnt));
                cnt++;
            }
        }
        Collections.sort(list);
        for(Pair pair : list){
            if(check(pair.s)) System.out.println(pair);
        }
    }
}