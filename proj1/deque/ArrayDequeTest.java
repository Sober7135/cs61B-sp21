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
}
