package test;

import java.io.Serializable;

public class Pair implements Comparable<Pair> , Serializable {
    private int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int compareTo(Pair o) {
        return this.first - o.first;
    }

    public String toString() {
        return String.format("(%d, %d)", first, second);
    }
}
