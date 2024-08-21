import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        while (t-- > 0) {
            Stack<Character> stack = new Stack<>();
            String s = sc.next();
            boolean check = true;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                    stack.push(s.charAt(i));
                }
                else{
                    if(stack.isEmpty()) check = false;
                    else{
                        if(map.get(stack.peek()) == s.charAt(i)){
                            stack.pop();
                        }
                        else check = false;
                    }
                }
            }
            if(check) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}