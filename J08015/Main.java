import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long [] a = new long[n];
            HashMap<Long, Long> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                a[i] = sc.nextLong();
                if(map.containsKey(a[i])) map.replace(a[i], map.get(a[i])+1);
                else map.put(a[i], 1L);
            }
            long ans = 0;
            for(int i = 0; i < n; i++){
                if(map.containsKey(k-a[i])){
                    ans += map.get(k-a[i]);
                    if(a[i] == k - a[i]) ans--;
                }
            }
            System.out.println(ans/2);
        }
    }
}
