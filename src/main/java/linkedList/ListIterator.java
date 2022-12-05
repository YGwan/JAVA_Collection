package linkedList;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<T> {

    private final YGLinkedList<T> ygLinkedList;
    private Node<T> next;
    private int nextIndex = 0;

    ListIterator(YGLinkedList<T> ygLinkedList, Node<T> head) {
        this.ygLinkedList = ygLinkedList;
        next = head;
    }

    public T next() {
        Node<T> previousNode = next;
        next = previousNode.next;
        nextIndex++;
        return previousNode.data;
    }

    public boolean hasNext() {
        return nextIndex < ygLinkedList.size();
    }

    public void remove() {
        if (nextIndex == 0) {
            throw new IllegalStateException();
        }
        ygLinkedList.remove(nextIndex - 1);
        nextIndex--;
    }
}