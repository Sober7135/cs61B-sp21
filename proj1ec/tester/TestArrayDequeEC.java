package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

import java.util.ArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void Test() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> ad = new StudentArrayDeque<>();
        StringBuilder message = new StringBuilder();

        for (int i = 0; i < 10000; i++) {
            double numberBetweenZeroToOne = StdRandom.uniform();
            if (numberBetweenZeroToOne < 0.25) {
                ads.addFirst(i);
                ad.addFirst(i);
                message.append("addFirst(").append(i).append(")\n");
            } else if (numberBetweenZeroToOne < 0.5) {
                ads.addLast(i);
                ad.addLast(i);
                message.append("addLast(").append(i).append(")\n");
            } else if (numberBetweenZeroToOne < 0.75) {
                Integer adsItem = ads.removeFirst();
                Integer adItem = ad.removeFirst();
                message.append("removeFirst()\n");
                assertEquals(message.toString(), adsItem, adItem);
            } else {
                Integer adsItem = ads.removeLast();
                Integer adItem = ad.removeLast();
                message.append("removeLast()\n");
                assertEquals(message.toString(), adsItem, adItem);
            }
        }
    }
}
