package dataStructure.linkedList;

import dataStructure.YGList;
import utils.Invalidator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class YGLinkedList<T> implements Iterable<T>, YGList<T> {

    private Node<T> head;
    private int size = 0;

    public YGLinkedList() {
    }

    public YGLinkedList(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
    }

    @Override
    public void add(int index, T input) {
        Invalidator.outOfIndexRangeAdd(index, size);
        Node<T> newNode = new Node<>(input);
        if (index == 0) {
            newNode.updateNext(head);
            head = newNode;
        } else {
            Node<T> previousNode = findNode(index - 1);
            Node<T> subsequentNode = previousNode.next();
            previousNode.updateNext(newNode);
            newNode.updateNext(subsequentNode);
        }
        size++;
    }

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
        add(size, input);
    }

    @Override
    public void remove() {
        remove(0);
    }

    @Override
    public void remove(int index) {
        Invalidator.outOfIndexRange(index, size);
        if (index == 0) {
            head = head.next();
        } else {
            Node<T> previousNode = findNode(index - 1);
            previousNode.updateNext(previousNode.next().next());
        }
        size--;
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T input) {
        for (int index = 0; index < size; index++) {
            if (get(index).equals(input)) return true;
        }
        return false;
    }

    @Override
    public void reverse() {
        YGLinkedList<T> currentNumbers = new YGLinkedList<>();
        for (T input : this) {
            currentNumbers.add(input);
        }
        int initialSize = this.size;

        for (int index = 0; index < initialSize; index++) {
            remove();
        }
        for (int index = 0; index < initialSize; index++) {
            addFirst(currentNumbers.get(index));
        }
    }

    @Override
    public T get(int index) {
        return findNode(index).data();
    }

    @Override
    public int indexOf(T data) {
        for (int index = 0; index < size; index++) {
            if (findNode(index).isSameData(data)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        int initialSize = size;
        for(int index = 0; index < initialSize; index++) {
            remove();
        }
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        Node<T> node = head;
        StringBuilder linkedListResult = new StringBuilder("[");

        while (node.next() != null) {
            linkedListResult.append(node.data()).append(", ");
            node = node.next();
        }
        return linkedListResult.append(node.data()).append("]").toString();
    }

    private Node<T> findNode(int index) {
        Node<T> node = head;
        for (int order = 0; order < index; order++) {
            node = node.next();
        }
        return node;
    }

    public ListIterator<T> listIterator() {
        return new ListIterator<>(YGLinkedList.this, head);
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
