package dataStructure.linkedList;

import dataStructure.AbstractYGList;
import java.util.Collection;
import java.util.Iterator;

public class YGLinkedList<T> extends AbstractYGList<T> {

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
    public int size() {
        return size;
    }

    @Override
    public void add(int index, T input) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("인덱스 값이 허용범위 밖입니다.");
        }
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
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("제거하려는 인덱스의 값이 올바르지 않습니다.");
        }
        if (index == 0) {
            head = head.next();
        } else {
            Node<T> previousNode = findNode(index - 1);
            previousNode.updateNext(previousNode.next().next());
        }
        size--;
    }

    @Override
    public T get(int index) {
        return findNode(index).data();
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
}
