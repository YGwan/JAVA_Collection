package dataStructure;

import dataStructure.arrayList.YGArrayList;

import java.util.Spliterator;
import java.util.function.Consumer;

public abstract class AbstractYGList<T> implements Iterable<T>, YGList<T> {

    @Override
    public void add(T input) {
        addLast(input);
    }

    @Override
    public void addFirst(T input) {
        add(0, input);
    }

    @Override
    public void addLast(T input) {
        add(size(), input);
    }

    @Override
    public void remove() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size() - 1);
    }

    @Override
    public void clear() {
        int currentSize = size();
        for (int index = 0; index < currentSize; index++) {
            remove();
        }
    }

    @Override
    public boolean contains(T input) {
        for (int index = 0; index < size(); index++) {
            if (get(index).equals(input)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        for (int index = 0; index < size(); index++) {
            if (get(index).equals(value)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public void reverse() {
        YGArrayList<T> currentNumbers = new YGArrayList<>();
        for (T input : this) {
            currentNumbers.add(input);
        }
        int initialSize = size();

        for (int index = 0; index < initialSize; index++) {
            remove();
        }
        for (int index = 0; index < initialSize; index++) {
            addFirst(currentNumbers.get(index));
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int currentSize = size();
        for (int index = 0; index < currentSize; index++) {
            sb.append(get(index));
            if (index < currentSize - 1) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
