import java.util.*;
import java.io.*;

class Matrix{
    private int[][] a = new int[100][100];
    private int n,m;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = 0;
            }
        }
    }
    public void nextMatrix(Scanner sc){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) this.a[i][j] = sc.nextInt();
        }
    }

    public Matrix trans(){
        Matrix b = new Matrix(m,n);
        for(int i = 0; i < b.n; i++){
            for(int j = 0; j < b.m; j++) b.a[i][j] = this.a[j][i];
        }
        return b;
    }
    public Matrix mul(Matrix b){
        Matrix matrix = new Matrix(this.n, b.m);
        for(int i = 0; i < matrix.n; i++){
            for(int j = 0; j < matrix.m; j++){
                for(int k = 0; k < this.m; k++){
                    matrix.a[i][j] += this.a[i][k] * b.a[k][j];
                }
            }
        }
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) sb.append(a[i][j]).append(" ");
            sb.append("\n");
        }
        return sb.toString();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt(), m = sc.nextInt();
            Matrix a = new Matrix(n,m);
            a.nextMatrix(sc);
            Matrix b = a.trans();
            System.out.println(a.mul(b));
        }
    }
}