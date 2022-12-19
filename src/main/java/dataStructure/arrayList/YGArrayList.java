package dataStructure.arrayList;

import dataStructure.AbstractYGList;
import java.util.Collection;
import java.util.Iterator;

public class YGArrayList<T> extends AbstractYGList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size = 0;
    private int currentCapacity = DEFAULT_CAPACITY;

    public YGArrayList(Collection<? extends T> c) {
        this.currentCapacity = c.size();
        this.elements = (T[]) new Object[currentCapacity];
        for (T t : c) {
            add(t);
        }
    }

    public YGArrayList() {
        this.elements = (T[]) new Object[currentCapacity];
    }

    public YGArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalStateException("초기 어레이 크기 설정값이 잘못되었습니다.");
        }
        this.currentCapacity = initialCapacity;
        this.elements = (T[]) new Object[currentCapacity];
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("인덱스의 값이 허용범위 밖입니다.");
        }
        resizeCapacity(size + 1);
        fastAdd(index);
        elements[index] = element;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("제거하려는 인덱스의 값이 옳바르지 않습니다.");
        }
        fastRemove(index);
    }

    public void remove(T inputValue) {
        for (int index = 0; index < size; index++) {
            if (elements[index] == inputValue) {
                fastRemove(index);
            }
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("가져오려는 값의 인덱스가 올바르지 않습니다.");
        }
        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    private void resizeCapacity(int capacity) {
        if (capacity > currentCapacity) {
            T[] copy = (T[]) new Object[capacity];
            System.arraycopy(elements, 0, copy, 0, elements.length);
            elements = copy;
            currentCapacity = capacity;
        }
    }

    private void fastRemove(int index) {
        for (int order = index + 1; order < size; order++) {
            elements[order - 1] = elements[order];
        }
        size--;
        elements[size] = null;
    }

    private void fastAdd(int index) {
        for (int order = size; order > index; order--) {
            elements[order] = elements[order - 1];
        }
        size++;
    }

    public ListIterator<T> listIterator() {
        return new ListIterator<>(this);
    }

    @Override
    public Iterator<T> iterator() {
        return listIterator();
    }
}

