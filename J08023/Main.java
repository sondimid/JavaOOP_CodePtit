import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for(int i = 0; i < n; i++) a[i] = sc.nextLong();
            Stack<Integer> stack = new Stack<>();
            long ans = -1;
            int i = 0;
            while(i < n){
                if(stack.isEmpty() || a[stack.peek()] <= a[i]){
                    stack.push(i);
                    i++;
                }
                else{
                    int idx = stack.peek();
                    stack.pop();
                    if(stack.isEmpty()) ans = Math.max(ans, a[idx] * i);
                    else ans = Math.max(ans, a[idx] * (i - stack.peek() -1));
                }
            }
            while(stack.isEmpty() == false){
                int idx = stack.peek();
                stack.pop();
                if(stack.isEmpty()) ans = Math.max(ans, a[idx] * i);
                else ans = Math.max(ans, a[idx] * (i - stack.peek() -1));
            }
            System.out.println(ans);
        }
    }
}