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

    private ArrayList<SetItem<E>> backingAL;

    public OrderlyHashSet() {
        backingAL = new ArrayList<>();
    }

    public OrderlyHashSet(int initialCapacity){
        backingAL = new ArrayList<>(initialCapacity);
    }

    @Override
    public int size() {
        return backingAL.size();
    }

    @Override
    public boolean isEmpty() {
        return backingAL.isEmpty();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {


        return Collections.binarySearch(backingAL, new SetItem<E>((E)o)) >= 0;

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Iterator<SetItem<E>> backingArrItr = backingAL.iterator();

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
        int binarySearchFeedbackVal = Collections.binarySearch(backingAL, setItem);

        if (binarySearchFeedbackVal >= 0) return false;//the set already has this elt

        backingAL.add((-(binarySearchFeedbackVal+1) ), setItem);
        return true;
    }


    @Override
    public boolean remove(Object o) {
        int binarySearchFeedbackVal = Collections.binarySearch(backingAL, new SetItem<E>((E)o));
        if(binarySearchFeedbackVal < 0)
        {
            return false;
        }
        backingAL.remove(binarySearchFeedbackVal);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object o : c)
        {
            if(!contains(o))
                return false;
        }
        return true;
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
        boolean changed = false;
        for(Object o:c)
        {
            if(remove(o))
            {
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public void clear() {
        backingAL.clear();
    }
}
