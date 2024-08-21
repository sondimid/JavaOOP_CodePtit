import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        Queue<String> q = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        q.add("9");
        arrayList.add(9);
        while(true){
            String front  = q.poll();
            if(front.length() >= 9) break;
            q.add(front + '0');
            q.add(front + '9');
            arrayList.add(Integer.parseInt(front + '0'));
            arrayList.add(Integer.parseInt(front + '9'));
        }
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int i = 0;
            while(arrayList.get(i) % n != 0) i++;
            System.out.println(arrayList.get(i));
        }
    }
}