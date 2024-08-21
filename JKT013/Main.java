import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        queue.add("6");
        queue.add("8");
        arrayList.add("6");
        arrayList.add("8");
        while(true){
            String front = queue.poll();
            if(front.length() >= 15) break;
            queue.add(front + '6');
            queue.add(front + '8');
            arrayList.add(front + '6');
            arrayList.add(front + '8');
        }
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int size = 0;
            while(arrayList.get(size).length() <= n) size++;
            System.out.println(size);
            for(int i = size - 1; i >=0; i--){
                System.out.print(arrayList.get(i) + " ");
            }
            System.out.println();
        }
    }
}