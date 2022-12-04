package linkedList;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class YGLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void addFirst(T input) {
        Node<T> newNode = new Node<T>(input);
        newNode.next = head;
        head = newNode;
        addSize();
        if (head.next == null) {
            tail = head;
        }
    }

    public void add(int index, T input) {
        if (index == 0) {
            addFirst(input);
        } else {
            Node<T> previousNode = findNode(index - 1);
            Node<T> subsequentNode = previousNode.next;
            Node<T> newNode = new Node<T>(input);
            previousNode.next = newNode;
            newNode.next = subsequentNode;
            addSize();
        }
    }

    public void add(T input) {
        addFirst(input);
    }

    public void addLast(T input) {
        Node<T> newNode = new Node<T>(input);
        if (size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            addSize();
        }
    }

    public void remove() {
        head = head.next;
        size--;
    }

    public void remove(int index) {
        if (index == 0) {
            remove();
        }
        Node<T> previousNode = findNode(index - 1);
        Node<T> doDeletedNode = previousNode.next;
        previousNode.next = previousNode.next.next;
        if (doDeletedNode == tail) {
            tail = previousNode;
        }
        size--;
    }

    public void removeLast() {
        remove(size - 1);
    }

    public Node<T> getHeadNode() {
        return head;
    }

    public int size() {
        return size;
    }

    protected void addSize() {
        size++;
    }

    public T get(int index) {
        return findNode(index).data;
    }

    public int indexOf(T data) {
        for (int index = 0; index < size; index++) {
            if (findNode(index).data == data) {
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
        StringBuilder str = new StringBuilder("[");

        while (node.next != null) {
            str.append(node.data).append(", ");
            node = node.next;
        }
        return str.append(node.data).append("]").toString();
    }

    private Node<T> findNode(int index) {
        Node<T> node = head;
        for (int order = 0; order < index; order++) {
            node = node.next;
        }
        return node;
    }

    public ListIterator listIterator() {
        return new ListIterator<T>(YGLinkedList.this);
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
