package Search;

public class BinarySearchST {

    private int[] keys;
    private int[] values;
    private int N;

    public BinarySearchST(int n) {
        keys = new int[n];
        values = new int[n];
    }

    public int rank(int key) {

        int mid;
        int low = 0, hight = N - 1; // 数组下标从0开始

        while (low <= hight) {
            mid = (hight + low) / 2;
            if (key < keys[mid]) {  // 获取索引mid的key值

                hight = mid - 1; // 排除mid元素
            } else if (key > keys[mid]) {
                low = mid + 1;  // 排除mid元素
            } else {
                return mid;
            }
        }

        return low;  // 返回小于key值元素数
    }

    public void put(int key, int value) {
        int i = rank(key);
        if (i < N && key == keys[i]) {
            values[i] = value;
            return;
        }

        for (int j = N; j > i; j--) {

            keys[N] = keys[j-1];
            values[N] = values[j-1]; // j-- j值会改变

        }
            keys[i] = key;
            values[i] = value;
            N++;
        return;
    }

    public int get(int key) {
        int value = rank(key);
        if (value == 0) {
            return 0;
        } else {
            return values[value];
        }
    }

//    public int delete(int key) {
//
//    }

    public static void main(String[] args) {
        int a = 0;
        System.out.println("a++ ="+a++);// 0
        System.out.println("++a = "+ ++a); // 2
    }
}
