import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("DATA.in"));
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close(); // Always close the scanner when done
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
