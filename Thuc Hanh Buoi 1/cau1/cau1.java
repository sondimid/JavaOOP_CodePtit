package cau1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class cau1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Double> list=new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(sc.nextDouble());
        }
        Collections.sort(list);
        double val = 0;
        double minVal = Collections.min(list);
        double maxVal = Collections.max(list);
        int sz = 0;
        for(Double d : list){
            if(d != minVal && d != maxVal){
                sz++;
                val +=d;
            }
        }
        System.out.println(String.format("%.2f", val / sz));
    }
}
