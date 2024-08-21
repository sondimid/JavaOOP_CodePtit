import java.util.*;
import java.io.*;

public class Main {
    public static long square(long[] a, int n){
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        long ans = -1;
        while(i < n){
            if(stack.isEmpty() || a[stack.peek()] <= a[i]){
                stack.push(i);
                i ++;
            }
            else{
                int top = stack.peek();
                stack.pop();
                if(!stack.isEmpty()) ans = Math.max(ans, a[top] * (i - stack.peek() - 1));
                else ans = Math.max(ans, a[top] * i);
            }
        }
        while(!stack.isEmpty()){
            int top = stack.peek();
            stack.pop();
            if(!stack.isEmpty()) ans = Math.max(ans, a[top] * (i - stack.peek() - 1));
            else ans = Math.max(ans, a[top] * i);
        }
        return ans;
    }
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[i] = m - a[i];
        }
        System.out.println(Math.max(square(a, n), square(b, n)));

    }
}