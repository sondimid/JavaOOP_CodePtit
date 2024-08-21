import java.util.*;
import java.io.*;

class IntSet{
    TreeSet<Integer> set = new TreeSet<>();

    public IntSet(int[] a) {
        for(Integer num : a) set.add(num);
    }
    public IntSet(TreeSet<Integer> set){
        this.set = set;
    }
    public IntSet intersection(IntSet s2){
        this.set.retainAll(s2.set);
        return new IntSet(this.set);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Integer num : this.set){
            sb.append(num).append(" ");
        }
        return sb.toString();
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}