package ArrayList;

import utils.Invalidator;
import java.util.Arrays;

public class YGArrayList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    public Object[] elementData;
    private int size = 0;

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

    public void addFirst(Object element) {
        add(0, element);
    }

    public void addLast(Object element) {
        add(size, element);
    }

    public void add(int index, Object element) {
        Invalidator.outOfIndexRange(index, size);
        resizeCapacity(size + 1);
        fastAdd(index);
        elementData[index] = element;
        size++;
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
}
