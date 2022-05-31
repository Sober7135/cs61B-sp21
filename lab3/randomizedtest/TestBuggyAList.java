package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> ba = new BuggyAList<>();
        AListNoResizing<Integer> anr = new AListNoResizing<>();

        ba.addLast(4);
        anr.addLast(4);
        ba.addLast(5);
        anr.addLast(5);
        ba.addLast(6);
        anr.addLast(6);

        for (int i = 0; i < 3; i++) {
            int barm = ba.removeLast();
            int anrrm = anr.removeLast();
            assertEquals(barm, anrrm);
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        AListNoResizing<Integer> anr = new AListNoResizing<>();

        int N = 500000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                anr.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int anrSize = anr.size();
                assertEquals(size, anrSize);
                System.out.println("size: " + size);
            } else if (L.size() != 0) {
                if (operationNumber == 2) {
                    // getLast
                    int returnItem = L.getLast();
                    int anrReturnItem = anr.getLast();
                    assertEquals(returnItem, anrReturnItem);
                    System.out.println("getLast(): " + returnItem);
                } else {
                    // removeLast
                    int returnItem = L.removeLast();
                    int anrReturnItem = anr.removeLast();
                    assertEquals(returnItem, anrReturnItem);
                    System.out.println("removeLast(): " + returnItem);
                }
            }
        }
    }
//    @Test
//    public void testRandom() {
//        BuggyAList<Integer> ba = new BuggyAList<>();
//        AListNoResizing<Integer> anr = new AListNoResizing<>();
//
//    for (int i = 0; i < 1000; ++i) {
//      int numberBetweenZeroAndOne = StdRandom.uniform(0, 2);
//      if (numberBetweenZeroAndOne == 0) {
//          ba.addLast(i);
//          anr.addLast(i);
//      } else if (numberBetweenZeroAndOne == 1) {
//          int barm = ba.removeLast();
//          int anrrm = anr.removeLast();
//          assertEquals(barm, anrrm);
//      }
//    }
//    }
}
