import java.util.*;

class IntSet{
    private Set<Integer> se;

    public IntSet(int[] a) {
        se = new TreeSet<>();
        for(int x: a) {
            se.add(x);
        }
    }

    private IntSet(Set<Integer> se){
        this.se = se;
    }
    public IntSet union(IntSet a){
        Set<Integer> se1 = new TreeSet<>(this.se);
        se1.addAll(a.se);
        return new IntSet(se1);
    }

    @Override
    public String toString() {
        String s = "";
        for(int x: this.se){
            s += Integer.toString(x)+" ";
        }
        return s;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
}
