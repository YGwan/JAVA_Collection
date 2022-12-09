package ArrayList;

import utils.Invalidator;

public class ListIterator {

    private  int nextIndex = 0;
    YGArrayList ygArrayList;
    Object[] elementData;

    public ListIterator(YGArrayList ygArrayList, Object[] elementData) {
        this.ygArrayList = ygArrayList;
        this.elementData = elementData;
    }

    public Object next() {
        Invalidator.nextMethodOutOfRange(nextIndex, ygArrayList.size());
        return elementData[nextIndex++];
    }

    public boolean hasNext() {
        return nextIndex < ygArrayList.size();
    }

    public Object previous() {
        Invalidator.previousMethodOutOfRange(nextIndex, ygArrayList.size());
        return elementData[--nextIndex];
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