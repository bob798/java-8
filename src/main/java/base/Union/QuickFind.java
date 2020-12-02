package Union;

public class QuickFind {

    int[] id;


    private QuickFind(int n) {

        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < this.id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public boolean find(int p, int q) {
        return id[p] == id[q];
    }
}
