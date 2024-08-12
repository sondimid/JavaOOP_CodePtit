import java.util.*;
import java.io.*;
class ComplexNum{
    private int real,imaginary;

    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public ComplexNum(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public void add(ComplexNum A){
        this.real += A.real;
        this.imaginary += A.imaginary;
    }
    public void mul(ComplexNum A){
        int a = this.real;
        int b = this.imaginary;
        int c = A.real;
        int d = A.imaginary;
        this.real = a*c-b*d;
        this.imaginary = a*d+b*c;
    }
    public void print(){
        System.out.print(this.real);
        if(this.imaginary < 0){
            System.out.print(" - " + Math.abs(this.imaginary));
        }
        else {
            System.out.print(" + " + this.imaginary);
        }
        System.out.print("i");
    }
}
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            ComplexNum a = new ComplexNum(sc.nextInt(),sc.nextInt());
            ComplexNum b = new ComplexNum(sc.nextInt(),sc.nextInt());
            ComplexNum A = a;
            ComplexNum B = new ComplexNum(b.getReal(),b.getImaginary());
            b.add(a);
            b.mul(a);
            b.print();
            System.out.print(", ");
            A.add(B);
            A.mul(A);
            A.print();
            System.out.println();
        }
    }
}