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
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        return potentialInsertionPoint(new SetItem<>((E) o)) == -1;
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
        return toArray(new Object[size()]);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] arr) {
        if (arr.length < size())
            arr = Arrays.copyOf(arr, size());

        int i = 0;
        for (E e : this) arr[i++] = (T) e;

        return arr;
    }

    @Override
    public boolean add(E elt) {
        SetItem<E> setItem = new SetItem<>(elt);
        int i = potentialInsertionPoint(setItem);

        if (i < 0) return false;

        backingArr.add(i, setItem);
        return true;
    }

    private int potentialInsertionPoint(SetItem<E> setItem) {
        int binarySearchFeedbackVal = Collections.binarySearch(backingArr, setItem);
        return binarySearchFeedbackVal >= 0 ? -1 : -(binarySearchFeedbackVal + 1);
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
