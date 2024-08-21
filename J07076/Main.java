import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATRIX.in"));
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int colum = sc.nextInt();
            int[][] a = new int[105][105];
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    a[i][j] = sc.nextInt();
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                list.add(a[i][colum]);
            }
            Collections.sort(list);
            for(int i = 1; i <= n; i++){
                a[i][colum] = list.get(i-1);
            }
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}