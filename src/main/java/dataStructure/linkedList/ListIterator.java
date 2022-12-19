package dataStructure.linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<T> implements Iterator<T> {

    private final YGLinkedList<T> ygLinkedList;
    private Node<T> next;
    private int nextIndex = 0;

    ListIterator(YGLinkedList<T> ygLinkedList, Node<T> head) {
        this.ygLinkedList = ygLinkedList;
        this.next = head;
    }

    public T next() {
        if (nextIndex >= ygLinkedList.size()) {
            throw new NoSuchElementException("ListIterator가 가리키는 값이 존재하지 않습니다.");
        }
        Node<T> previousNode = next;
        next = previousNode.next();
        nextIndex++;
        return previousNode.data();
    }

    public boolean hasNext() {
        return nextIndex < ygLinkedList.size();
    }

    public void remove() {
        if (nextIndex == 0) {
            throw new IllegalStateException("ListIterator가 가리키는 값이 존재하지 않습니다.");
        }
        ygLinkedList.remove(nextIndex - 1);
        nextIndex--;
    }
}
