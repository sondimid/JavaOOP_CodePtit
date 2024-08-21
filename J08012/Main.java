import java.util.*;
import java.io.*;

public class Main {
    public static int[] par = new int[100005];
    public static int[] size = new int[100005];
    public static void init(){
        for(int i = 1; i <= 100000; i++){
            par[i] = i;
            size[i] = 1;
        }
    }
    public static int find(int u){
        if(par[u] == u) return u;
        return par[u] = find(par[u]);
    }
    public static boolean Union(int u, int v){
        int a = find(u);
        int b = find(v);
        if(a == b) return false;
        par[b] = a;
        size[a] += size[b];
        return true;
    }
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        init();
        int n = sc.nextInt();
        boolean check = true;
        while(n-->1){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(!Union(a,b)) check = false;
        }
        if(check) System.out.println("Yes");
        else System.out.println("No");
    }
}