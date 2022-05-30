package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    /** Test method AddFirst. */
    public void testAddFirst() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addLast(0);
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        L.addLast(4);
        L.addLast(5);
        L.addLast(6);
        L.addLast(7);
        L.addFirst(8);
        System.out.println(L.size());
        L.removeFirst();
        System.out.println(L.size());
        L.printDeque();
    }

    @Test
    public void testResize() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addFirst(0);
        L.removeFirst();
        L.addLast(2);
        L.printDeque();
    }

    @Test
    public void equalTest() {
        ArrayDeque<Integer> l1 = new ArrayDeque<>();
        ArrayDeque<Integer> l2 = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            l1.addFirst(i);
            l2.addFirst(i);
        }
        assertEquals(true, l1.equals(l2));

        LinkedListDeque<Integer> d1 = new LinkedListDeque<>();
        ArrayDeque<Integer> d2 = new ArrayDeque<>();

        for (int i = 0; i < 100; i++) {
            d1.addFirst(i);
            d2.addFirst(i);
        }
        assertEquals(true, l1.equals(l2));
    }

    @Test
    public void removeFirstTest() {
        ArrayDeque<Integer> l1 = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            l1.addFirst(i);
        }
        int ret = l1.removeFirst();
        System.out.println(ret);
    }

    @Test
    public void shrinkTest() {
        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        for (int i = 0; i < 16; i++) {
            a1.addLast(i);
        }
        for (int i = 1; i < 16; i++) {
            a1.removeLast();
        }
    }

    @Test
    public void resizeTest() {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addFirst(0);
        ArrayDeque.get(0);
        ArrayDeque.addLast(2);
        ArrayDeque.addFirst(3);
        ArrayDeque.addLast(4);
        ArrayDeque.addFirst(5);
        ArrayDeque.addFirst(6);
        ArrayDeque.addLast(7);
        ArrayDeque.removeFirst();
        ArrayDeque.addLast(9);
        ArrayDeque.addFirst(10);
        ArrayDeque.get(3);
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.addFirst(14);
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.removeLast();

    }
}
