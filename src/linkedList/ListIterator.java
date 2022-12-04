package linkedList;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<T> {

    private final YGLinkedList<T> YGLinkedList;
    private Node<T> next;
    private int nextIndex = 0;

    ListIterator(YGLinkedList<T> YGLinkedList) {
        this.YGLinkedList = YGLinkedList;
        next = YGLinkedList.getHeadNode();
    }

    public T next() {
        Node<T> previousNode = next;
        next = previousNode.next;
        nextIndex++;
        return previousNode.data;
    }

    public boolean hasNext() {
        return nextIndex < YGLinkedList.size();
    }

    public void remove() {
        if (nextIndex == 0) {
            throw new IllegalStateException();
        }
        YGLinkedList.remove(nextIndex - 1);
        nextIndex--;
    }
}