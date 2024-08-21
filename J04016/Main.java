import java.util.*;
import java.io.*;

class Matrix{
    private int[][] a = new int[100][100];
    private int n,m;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
    }
    public void nextMatrix(Scanner sc){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = sc.nextInt();
            }
        }
    }

    public Matrix mul(Matrix b){
        Matrix matrix = new Matrix(this.n, b.m);
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < b.m; j++){
                matrix.a[i][j] = 0;
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
            for(int j = 0; j < n; j++){
                sb.append(a[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();
        Matrix a = new Matrix(n,m);
        a.nextMatrix(sc);
        Matrix b = new Matrix(m,p);
        b.nextMatrix(sc);
        System.out.println(a.mul(b));
    }
}