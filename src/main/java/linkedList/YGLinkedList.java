package linkedList;

import utils.Invalidator;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class YGLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private int size = 0;

    public YGLinkedList() {
    }

    public YGLinkedList(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
    }

    public void add(int index, T input) {
        Invalidator.outOfIndexRangeAdd(index,size);
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

    public void add(T input) {
        addLast(input);
    }

    public void addFirst(T input) {
        add(0,input);
    }

    public void addLast(T input) {
        add(size, input);
    }

    public void remove() {
        remove(0);
    }

    public void remove(int index) {
        Invalidator.outOfIndexRangeRemove(index,size);
        if (index == 0) {
            head = head.next();
        } else {
            Node<T> previousNode = findNode(index - 1);
            previousNode.updateNext(previousNode.next().next());
        }
        size--;
    }

    public void removeLast() {
        remove(size - 1);
    }

    public int size() {
        return size;
    }

    public boolean contains(T input) {
        for(int index = 0; index < size; index++) {
            if(get(index).equals(input)) return true;
        }
        return false;
    }

    public void reverse() {
        YGLinkedList<T> currentNumbers = new YGLinkedList<>();
        for(T input : this) {
            currentNumbers.add(input);
        }
        int initialSize = this.size;

        for(int index = 0; index < initialSize; index++) {
            remove();
        }
        for(int index = 0; index < initialSize; index++) {
            addFirst(currentNumbers.get(index));
        }
    }

    public T get(int index) {
        return findNode(index).data();
    }

    public int indexOf(T data) {
        for (int index = 0; index < size; index++) {
            if (findNode(index).isSameData(data)) {
                return index;
            }
        }
        return -1;
    }

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
