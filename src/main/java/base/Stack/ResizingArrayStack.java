package Stack;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];

        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(a.length * 2);
        }
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {  // ? why division 4
            resize(a.length / 2);
        }
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> arrayStack = new ResizingArrayStack<>();

        arrayStack.resize(10);
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        arrayStack.push("5");


        System.out.println("弹出栈顶元素 :: " + arrayStack.pop());
        System.out.println("stack size = " + arrayStack.size());
        arrayStack.push("6");
        System.out.println("--------" + "迭代开始" + "--------");
        for (String item : arrayStack) {
            System.out.println(item);
        }

        /**
         *
         *
         *
         * 弹出栈顶元素 :: 5
         * stack size = 4
         * --------迭代开始--------
         * 6
         * 4
         * 3
         * 2
         * 1
         */

    }
}
