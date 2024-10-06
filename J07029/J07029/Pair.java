package J07029;

public class Pair implements Comparable<Pair> {
    private Integer key;
    private Integer value;

    public Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        return o.key.compareTo(this.key);
    }

    @Override
    public String toString() {
        return key + "  " + value;
    }
}
