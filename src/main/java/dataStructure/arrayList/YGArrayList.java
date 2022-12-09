package dataStructure.arrayList;

import dataStructure.YGList;
import utils.Invalidator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class YGArrayList<T> implements Iterable<T>, YGList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private Object[] elementData;
    private int size = 0;

    public YGArrayList(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
    }

    public YGArrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    public YGArrayList(int initialCapacity) {

        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            Invalidator.notAppreciateValue(initialCapacity);
        }
    }

    @Override
    public void addFirst(T element) {
        add(0, element);
    }

    @Override
    public void addLast(T element) {
        add(size, element);
    }

    @Override
    public void add(int index, T element) {
        Invalidator.outOfIndexRangeAdd(index, size);
        resizeCapacity(size + 1);
        fastAdd(index);
        elementData[index] = element;
        size++;
    }

    @Override
    public void add(T element) {
        add(size, element);
    }

    @Override
    public void remove(int index) {
        Invalidator.outOfIndexRange(index, size);
        fastRemove(index);
    }

    @Override
    public void remove() {
        remove(0);
    }

    public void remove(T inputValue) {
        removeIfSameInputValue(inputValue);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public boolean contains(T input) {
        for (int index = 0; index < size; index++) {
            if (get(index).equals(input)) return true;
        }
        return false;
    }

    @Override
    public T get(int index) {
        Invalidator.outOfIndexRange(index, size);
        return elementData(index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(T value) {
        for (int index = 0; index < size; index++) {
            if (elementData[index] == value) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public void reverse() {
        Object[] reverseElement = new Object[size];
        for (int index = 0; index < size; index++) {
            reverseElement[index] = elementData[size - index - 1];
        }

        System.arraycopy(reverseElement, 0, elementData, 0, size);
    }

    @Override
    public void clear() {
        for (int index = 0; index < size; index++) {
            elementData[index] = null;
        }
        size = 0;
    }

    private void removeIfSameInputValue(T inputValue) {
        for (int index = 0; index < size; index++) {
            if (elementData[index] == inputValue) {
                fastRemove(index);
            }
        }
    }

    private void fastRemove(int index) {
        for (int order = index + 1; order < size; order++) {
            elementData[order - 1] = elementData[order];
        }
        size--;
        elementData[size] = null;
    }

    private void resizeCapacity(int capacity) {
        growUpCapacity(calculateCapacity(elementData, capacity));
    }

    private static int calculateCapacity(Object[] elementData, int capacity) {
        if (Arrays.equals(elementData, EMPTY_ELEMENTDATA)) {
            return Math.max(DEFAULT_CAPACITY, capacity);
        }
        return capacity;
    }

    private Object[] grow(Object[] elementData, int capacity) {
        Object[] copy = new Object[capacity];
        System.arraycopy(elementData, 0, copy, 0, elementData.length);
        return copy;
    }

    private void growUpCapacity(int capacity) {
        if (capacity > elementData.length) {
            elementData = grow(elementData, capacity);
        }
    }

    private void fastAdd(int index) {
        for (int order = size; order > index; order--) {
            elementData[order] = elementData[order - 1];
        }
    }

    T elementData(int index) {
        return (T) elementData[index];
    }

    @Override
    public String toString() {
        StringBuilder ygArrayListResult = new StringBuilder("[");
        for (int index = 0; index < size; index++) {
            printElementData(ygArrayListResult, index);
        }
        return ygArrayListResult.append("]").toString();
    }

    private void printElementData(StringBuilder ygArrayListResult, int index) {
        ygArrayListResult.append(elementData[index]);
        if (index < size - 1) {
            ygArrayListResult.append(", ");
        }
    }

    public ListIterator<T> listIterator() {
        return new ListIterator<>(this);
    }

    @Override
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
