package com.citron.collections;

import java.util.*;

public class OrderlyHashSet<E> implements Set<E>{

    private static class SetItem<E> implements Comparable<SetItem<E>> {
        private E data;
        private int hashCode;

        private SetItem(E elt)
        {
            data = elt;
            hashCode = elt.hashCode();
        }

        @Override
        public int compareTo(SetItem<E> that) {
            return Integer.compare(hashCode, that.hashCode);
        }
    }

    private ArrayList<SetItem<E>> backingArr;

    public OrderlyHashSet() {
        backingArr = new ArrayList<>();
    }

    public OrderlyHashSet(int initialCapacity){
        backingArr = new ArrayList<>(initialCapacity);
    }

    @Override
    public int size() {
        return backingArr.size();
    }

    @Override
    public boolean isEmpty() {
        return backingArr.isEmpty();
    }

    @Override
    public boolean contains(Object o) {

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Iterator<SetItem<E>> backingArrItr = backingArr.iterator();

            @Override
            public boolean hasNext() {
                return backingArrItr.hasNext();
            }

            @Override
            public E next() {
                return backingArrItr.next().data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E elt) {
        SetItem<E> setItem = new SetItem<>(elt);
        int i = potentialIndexOf(setItem);

        if (i < 0) return false;

        backingArr.add(i, setItem);
        return true;
    }

    private int potentialIndexOf(SetItem<E> setItem) {
        int binarySearchFeedbackVal = Collections.binarySearch(backingArr, setItem);
        return binarySearchFeedbackVal >= 0 ? -1 : -binarySearchFeedbackVal + 1;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        backingArr.clear();
    }
}
