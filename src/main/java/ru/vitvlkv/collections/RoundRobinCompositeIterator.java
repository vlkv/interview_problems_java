package ru.vitvlkv.collections;

import java.util.Iterator;

public class RoundRobinCompositeIterator<E> implements Iterator<E> {

    private Iterator<E>[] iterators;
    private int current = 0;

    public RoundRobinCompositeIterator(Iterator<E> ...iterators) {
        if (iterators.length == 0) {
            throw new IllegalArgumentException("At least one iterator should be given");
        }
        this.iterators = iterators;
        skipUntilHasNext();
    }

    @Override
    public boolean hasNext() {
        return iterators[current].hasNext();
    }

    @Override
    public E next() {
        E result = iterators[current].next();
        incCurrent();
        skipUntilHasNext();
        return result;
    }

    /** @returns success or not */
    private boolean skipUntilHasNext() {
        int count = 0;
        while (!iterators[current].hasNext() && count < iterators.length) {
            incCurrent();
            count++;
        }
        return count < iterators.length;
    }

    private void incCurrent() {
        current = ++current % iterators.length;
    }

}
