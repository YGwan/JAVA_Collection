package dataStructure.arrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<T> implements Iterator<T> {

    private int nextIndex = 0;
    private final YGArrayList<T> ygArrayList;

    public ListIterator(YGArrayList<T> ygArrayList) {
        this.ygArrayList = ygArrayList;
    }

    public T next() {
        if (nextIndex >= ygArrayList.size()) {
            throw new NoSuchElementException("ListIterator가 가리키는 값이 존재하지 않습니다.");
        }
        T element = ygArrayList.get(nextIndex);
        nextIndex++;
        return element;
    }

    public boolean hasNext() {
        return nextIndex < ygArrayList.size();
    }

    public T previous() {
        int previousIndex = nextIndex - 1;
        if (previousIndex < 0) {
            throw new NoSuchElementException("ListIterator가 가리키는 값이 존재하지 않습니다.");
        }
        nextIndex--;
        return ygArrayList.get(nextIndex);
    }

    public boolean hasPrevious() {
        return nextIndex > 0;
    }

    public void remove() {
        if (nextIndex == 0) {
            throw new IllegalStateException("ListIterator가 가리키는 값이 존재하지 않습니다.");
        }
        nextIndex--;
        ygArrayList.remove(nextIndex);
    }
}