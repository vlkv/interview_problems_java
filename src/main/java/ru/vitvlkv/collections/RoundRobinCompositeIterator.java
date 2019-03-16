package ru.vitvlkv.collections;

import java.util.*;

public class RoundRobinCompositeIterator<E> implements Iterator<E> {

    private List<Iterator<E>> iterators;
    private Iterator<Iterator<E>> i;
    private Iterator<E> iterator;

    public RoundRobinCompositeIterator(Iterator<E> ...iterators) {
        if (iterators.length == 0) {
            throw new IllegalArgumentException("At least one iterator should be given");
        }
        this.iterators = new LinkedList<>();
        Arrays.stream(iterators)
                .filter(it -> it.hasNext())
                .forEach(it -> this.iterators.add(it));
        incCurrent();
        skipUntilHasNext();
    }

    @Override
    public boolean hasNext() {
        return !iterators.isEmpty() && iterator.hasNext();
    }

    @Override
    public E next() {
        if (iterators.isEmpty()) {
            throw new NoSuchElementException();
        }
        E result = iterator.next();
        incCurrent();
        skipUntilHasNext();
        return result;
    }

    private void skipUntilHasNext() {
        while (!iterators.isEmpty() && !iterator.hasNext()) {
            i.remove();
            incCurrent();
        }
    }

    private void incCurrent() {
        if (i == null || !i.hasNext()) {
            i = iterators.iterator();
        }
        iterator = i.hasNext() ? i.next() : null;
    }
}
