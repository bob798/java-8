package Stack;


public class StackArrayOfString {


    private String[] a; // stack entries
    private int N;      // size

    public StackArrayOfString(int cap) {
        this.a = new String[cap];
    }

    public String push(String item) {
        return a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
}
