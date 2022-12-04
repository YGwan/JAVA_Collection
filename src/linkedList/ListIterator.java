package linkedList;

import java.util.Iterator;

public class ListIterator implements Iterator {

    private final LinkedList linkedList;
    private Node next;
    private int nextIndex = 0;

    ListIterator(LinkedList linkedList) {
        this.linkedList = linkedList;
        next = linkedList.getHeadNode();
    }

    public Object next() {
        Node previousNode = next;
        next = previousNode.next;
        nextIndex++;
        return previousNode.data;
    }

    public boolean hasNext() {
        return nextIndex < linkedList.size();
    }

    public void remove() {
        if (nextIndex == 0) {
            throw new IllegalStateException();
        }
        linkedList.remove(nextIndex - 1);
        nextIndex--;
    }
}