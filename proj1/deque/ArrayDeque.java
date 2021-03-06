package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }


    private int minusOne(int num) {
        return Math.floorMod(num - 1, items.length);
    }

    private int plusOne(int num) {
        return Math.floorMod(num + 1, items.length);
    }

    private void resize(int capacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity];
        int start = plusOne(nextFirst);
        int end = minusOne(nextLast);
        if (start <= end) {
            System.arraycopy(items, start, temp, 0, end - start + 1);
        } else {
            System.arraycopy(items, start, temp, 0, items.length - start);
            System.arraycopy(items, 0, temp, items.length - start, end + 1);
        }
        nextFirst = temp.length - 1;
        nextLast = size;
        items = temp;
    }

    private void expand() {
        resize(items.length * 2);
    }


    private void shrink() {
        resize(items.length / 2);
    }


    @Override
    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
        if (size == items.length) {
            expand();
        }
    }

    @Override
    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
        if (size == items.length) {
            expand();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = plusOne(nextFirst); i != minusOne(nextLast); i = plusOne(i)) {
            System.out.print(items[1] + " ");
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T ret = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        size--;
        if (items.length >= 16 && size < items.length / 4) {
            shrink();
        }
        return ret;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T ret = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        size--;
        if (items.length >= 16 && size < items.length / 4) {
            shrink();
        }
        return ret;
    }

    @Override
    public T get(int index) {
        return items[Math.floorMod(index + nextFirst + 1, items.length)];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        int wizardPos;

        ArrayDequeIterator() {
            wizardPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizardPos < size;
        }

        @Override
        public T next() {
            T returnItem = get(wizardPos);
            wizardPos++;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Deque)) {
            return false;
        }
        @SuppressWarnings("unchecked")
        Deque<T> o = (Deque<T>) obj;
        if (size != o.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(o.get(i))) {
                return false;
            }
        }
        return true;
    }

//    auto generated by intellij.
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ArrayDeque<?> that = (ArrayDeque<?>) o;
//        return size == that.size && nextFirst
//        == that.nextFirst && nextLast
//        == that.nextLast && Arrays.equals(items, that.items);
//    }
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(size, nextFirst, nextLast);
//        result = 31 * result + Arrays.hashCode(items);
//        return result;
//    }
}
