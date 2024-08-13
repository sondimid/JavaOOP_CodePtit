import java.util.*;

class WordSet {
    private Set<String> se;

    public WordSet(String s) {
        this.se = new TreeSet<>();
        String[] tmp = s.toLowerCase().split("\\s+");
        this.se.addAll(Arrays.asList(tmp));
    }

    public WordSet(Set<String> se) {
        this.se = new TreeSet<>(se); // Deep copy
    }

    public WordSet union(WordSet A) {
        Set<String> se1 = new TreeSet<>(this.se);
        se1.addAll(A.se);
        return new WordSet(se1);
    }

    public WordSet intersection(WordSet A) {
        Set<String> se1 = new TreeSet<>(this.se);
        se1.retainAll(A.se);
        return new WordSet(se1);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String x : this.se) {
            s.append(x).append(" ");
        }
        return s.toString().trim();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
