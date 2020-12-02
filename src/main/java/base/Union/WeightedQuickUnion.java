package Union;

public class WeightedQuickUnion {

    int[] id;
    int[] sz;

    private WeightedQuickUnion(int n) {
        this.id = new int[n];
        this.sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public void union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        if (sz[pRoot] >= sz[qRoot]) {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
            sz[qRoot] = 0;
        } else {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
            sz[qRoot] = 0;
        }

    }

    public boolean find(int p, int q) {
        return getRoot(p) == getRoot(q);
    }


    public int getRoot(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}
