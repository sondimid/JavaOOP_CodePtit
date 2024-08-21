import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] b = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                b[i] = 1;
            }
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < n; i++){
                if(stack.isEmpty()) stack.push(i);
                else{
                    while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                        stack.pop();
                    }
                    if(!stack.isEmpty()) b[i] = i - stack.peek();
                    else b[i] = i + 1;
                    stack.push(i);
                }
            }
            for(Integer num : b) System.out.print(num + " ");
            System.out.println();
        }
    }
}