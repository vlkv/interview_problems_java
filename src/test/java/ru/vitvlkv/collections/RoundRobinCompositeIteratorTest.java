package ru.vitvlkv.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

public class RoundRobinCompositeIteratorTest {

    @Test
    public void simpleCase() {
        Collection<Integer> c1 = Arrays.asList(1, 4, 6, 7, 8);
        Collection<Integer> c2 = Arrays.asList(2, 5);
        Collection<Integer> c3 = Arrays.asList(3);

        RoundRobinCompositeIterator<Integer> it =
                new RoundRobinCompositeIterator<>(c1.iterator(), c2.iterator(), c3.iterator());

        Integer i = 1;
        while (it.hasNext()) {
            Assert.assertEquals(i, it.next());
            i += 1;
        }

        Exception ex = null;
        try {
            it.next();
        } catch (NoSuchElementException ex1) {
            ex = ex1;
        } finally {
            Assert.assertNotNull(ex);
        }
    }

    @Test
    public void firstEmpty() {
        Collection<Integer> c1 = Arrays.asList();
        Collection<Integer> c2 = Arrays.asList(1, 3, 5, 7, 8);
        Collection<Integer> c3 = Arrays.asList(2, 4, 6);

        RoundRobinCompositeIterator<Integer> it =
                new RoundRobinCompositeIterator<>(c1.iterator(), c2.iterator(), c3.iterator());

        Integer i = 1;
        while (it.hasNext()) {
            Assert.assertEquals(i, it.next());
            i += 1;
        }

        Exception ex = null;
        try {
            it.next();
        } catch (NoSuchElementException ex1) {
            ex = ex1;
        } finally {
            Assert.assertNotNull(ex);
        }
    }

    @Test
    public void allEmpty() {
        Collection<Integer> c1 = Arrays.asList();
        Collection<Integer> c2 = Arrays.asList();

        RoundRobinCompositeIterator<Integer> it =
                new RoundRobinCompositeIterator<>(c1.iterator(), c2.iterator());

        Assert.assertFalse(it.hasNext());

        Exception ex = null;
        try {
            it.next();
        } catch (NoSuchElementException ex1) {
            ex = ex1;
        } finally {
            Assert.assertNotNull(ex);
        }
    }
}
