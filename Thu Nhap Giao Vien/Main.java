import java.util.Scanner;

public class Main {
    public static void main(String []arg){
        Scanner sc = new Scanner(System.in);
        GV a = new GV(sc.nextLine(),sc.nextLine(),sc.nextLong());
        a.salary();
        System.out.println(a.getMa()+" "+a.getTen()+" "+a.getHeSo()+" "+a.getPhuCap()+" " +a.getSalary());
    }
}
