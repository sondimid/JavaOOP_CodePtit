import java.util.*;
import java.io.*;

class WordSet{
    private TreeSet<String> set = new TreeSet<>();

    public WordSet(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        while(sc.hasNext()) set.add(sc.next().toLowerCase());
    }

    public WordSet(){
    }

    public WordSet difference(WordSet o){
        WordSet ans = new WordSet();
        for(String s : this.set) ans.set.add(s);
        ans.set.removeAll(o.set);
        return ans;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String s : set) sb.append(s).append(" ");
        return sb.toString();
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}