import java.util.*;
import java.io.*;

class WordSet{
    private TreeSet<String> set = new TreeSet<>();

    public WordSet(TreeSet<String> set){
        this.set = set;
    }
    public WordSet(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        while(sc.hasNext()){
            this.set.add(sc.next().toLowerCase());
        }
    }

    public WordSet union(WordSet o){
        TreeSet<String> se = new TreeSet<>();
        se.addAll(this.set);
        se.addAll(o.set);
        return new WordSet(se);
    }

    public WordSet intersection(WordSet o){
        TreeSet<String> se = new TreeSet<>();
        se.addAll(this.set);
        se.retainAll(o.set);
        return new WordSet(se);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String s : set){
            sb.append(s).append(" ");
        }
        return sb.toString();
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}