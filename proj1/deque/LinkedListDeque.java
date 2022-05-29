package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node {
        Node prev;
        T item;
        Node next;

        Node(Node p, T t, Node n) {
            prev = p;
            item = t;
            next = n;
        }
    }

    // sentinel.next is the first list.
    private final Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    @Override
    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    @Override
    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (Node temp = sentinel.next; temp != sentinel; temp = temp.next) {
            System.out.print(temp.item + " ");
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return res;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T res = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return res;
    }

    @Override
    public T get(int index) {
        if (isEmpty()) {
            return null;
        }

        Node temp = sentinel.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.item;
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }

    // Helper for getRecursive methods.
    private T getRecursive(int index, Node temp) {
        if (index == 0) {
            return temp.item;
        }

        return getRecursive(index - 1, temp.next);
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        int wizardPos;

        LinkedListDequeIterator() {
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
        if (!(obj instanceof ArrayDeque) || !(obj instanceof LinkedListDeque)) {
            return false;
        }
        Deque<T> o = (Deque<T>) obj;
        if (this.size != o.size()) {
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
//        LinkedListDeque<?> that = (LinkedListDeque<?>) o;
//        return size == that.size && Objects.equals(sentinel, that.sentinel);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(sentinel, size);
//    }
}