import java.util.*;

class DaThuc {
    private String s;
    private HashMap<Integer, Integer> mp = new HashMap<>();

    public DaThuc(String s) {
        this.s = s.trim();
        String[] terms = s.split(" \\+ ");
        for (String term : terms) {
            term = term.trim();
            if (term.isEmpty()) continue;

            int coeff = 0;
            int pow = 0;

            int xIndex = term.indexOf('*');
            int caretIndex = term.indexOf('^');

            if (xIndex != -1) {
                coeff = Integer.parseInt(term.substring(0, xIndex).trim());
            }

            if (caretIndex != -1) {
                pow = Integer.parseInt(term.substring(caretIndex + 1).trim());
            } else if (xIndex != -1) {
                pow = 1;  // If no ^ is present, the power is 1
            }

            mp.put(pow, mp.getOrDefault(pow, 0) + coeff);
        }
    }

    public DaThuc() {
        this.s = "";
    }

    public DaThuc cong(DaThuc o) {
        DaThuc result = new DaThuc();
        result.mp.putAll(this.mp);

        for (Map.Entry<Integer, Integer> entry : o.mp.entrySet()) {
            result.mp.put(entry.getKey(), result.mp.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        return result;
    }

    @Override
    public String toString() {
        if (mp.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        boolean firstTerm = true;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int coeff = entry.getValue();
            int pow = entry.getKey();

            if (coeff == 0) continue;

            if (!firstTerm) {
                if (coeff > 0) {
                    sb.append(" + ");
                } else {
                    sb.append(" - ");
                    coeff = -coeff;
                }
            } else if (coeff < 0) {
                sb.append("-");
                coeff = -coeff;
            }

            if (coeff != 1 || pow == 0) {
                sb.append(coeff);
            }
            if (pow > 0) {
                sb.append("*x");
                if (pow > 1) {
                    sb.append("^").append(pow);
                }
            }

            firstTerm = false;
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            System.out.println(p);
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
        sc.close();
    }
}
