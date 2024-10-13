import java.util.*;
import java.math.BigInteger;

public class thuaSoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int P = scanner.nextInt();

        List<BigInteger> powers = new ArrayList<>();
        BigInteger pBig = BigInteger.valueOf(P);
        BigInteger limit = BigInteger.valueOf((long) 1e9);

        BigInteger current = BigInteger.ONE;
        while (true) {
            current = current.multiply(pBig);
            if (current.compareTo(limit) > 0) break;
            powers.add(current);
        }

        if (powers.size() < K) {
            System.out.println(0);
        } else {
            System.out.println(powers.get(K - 1));
        }
    }
}
