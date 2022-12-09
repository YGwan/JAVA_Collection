package ArrayList;

import utils.Invalidator;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<T> {

    private  int nextIndex = 0;
    private final YGArrayList<T> ygArrayList;

    public ListIterator(YGArrayList<T> ygArrayList) {
        this.ygArrayList = ygArrayList;
    }

    public T next() {
        Invalidator.nextMethodOutOfRange(nextIndex, ygArrayList.size());
        return ygArrayList.elementData(nextIndex++);
    }

    public boolean hasNext() {
        return nextIndex < ygArrayList.size();
    }

    public T previous() {
        Invalidator.previousMethodOutOfRange(nextIndex, ygArrayList.size());
        return ygArrayList.elementData(--nextIndex);
    }

    public boolean hasPrevious() {
        return nextIndex > 0;
    }

    public void remove() {
        Invalidator.iteratorRemoveNextIndexZero(nextIndex);
        ygArrayList.remove(nextIndex-1);
        nextIndex--;
    }
}