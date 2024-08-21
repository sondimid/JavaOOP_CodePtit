import javax.print.DocFlavor;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i = 0; i < n; i++){
                b[i] = -1;
                a[i] = sc.nextInt();
            }
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < n; i++){
                if(stack.isEmpty()) stack.push(i);
                else{
                    while(!stack.isEmpty() && a[stack.peek()] < a[i]){
                        b[stack.peek()] = a[i];
                        stack.pop();
                    }
                    stack.push(i);
                }
            }
            for(int i = 0; i < n; i++){
                System.out.print(b[i] + " ");
            }
            System.out.println();
        }
    }
}