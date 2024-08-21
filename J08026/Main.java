import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            HashMap<Integer, Integer> map = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            int s = sc.nextInt();
            int t = sc.nextInt();
            map.put(s, 0);
            queue.add(s);
            while(!map.containsKey(t)){
                int front = queue.poll();
                if(front - 1 > 0 && !map.containsKey(front -1 )){
                    map.put(front - 1, map.get(front) + 1);
                    queue.add(front - 1);
                }
                if(front < t && !map.containsKey(front * 2)){
                    map.put(front * 2, map.get(front) + 1);
                    queue.add(front * 2);
                }
            }
            System.out.println(map.get(t));
        }
    }
}