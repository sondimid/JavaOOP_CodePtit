import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    String key;
    int val;
    public Pair(String key, int val){
        this.key = key;
        this.val = 1;
    }

    @Override
    public String toString() {
        return key + " " +val;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.val == o.val) return this.key.compareTo(o.key);
        return Integer.compare(o.val, this.val);
    }
}
public class Main {
    public static boolean check(String s){
        for(int i = 0; i < s.length(); i++){
            if(!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        int n = sc.nextInt();
        LinkedList<Pair> list = new LinkedList<>();
        sc.nextLine();
        while(n-- > 0){
            String[] s = sc.nextLine().toLowerCase().trim().split("\\s+");
            for(int i = 0; i < s.length; i++){
                boolean test = true;
                for(Pair pair : list){
                    if(pair.key.equals(s[i])){
                        pair.val +=1;
                        test = false;
                        break;
                    }
                }
                if(test) list.add(new Pair(s[i], 1));
            }
        }
        Collections.sort(list);
        for(Pair pair : list) System.out.println(pair);
    }
}