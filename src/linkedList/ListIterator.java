package linkedList;

public class ListIterator {

    private final LinkedList linkedList;
    private Node next;
    private Node previousNode;
    private int nextIndex = 0;

    ListIterator(LinkedList linkedList) {
        this.linkedList = linkedList;
        next = linkedList.getHeadNode();
    }

    public Object next() {
        previousNode = next;
        next = previousNode.next;
        nextIndex++;
        return previousNode.data;
    }

    public boolean hasNext() {
        return nextIndex < linkedList.size();
    }

    public void add(Object input) {
        Node newNode = new Node(input);

        if (previousNode == null) {
            linkedList.setHeadNode(newNode);
        } else {
            previousNode.next = newNode;
        }
        newNode.next = next;
        previousNode = newNode;
        nextIndex++;
        linkedList.addSize();
    }

    public void remove() {
        if(nextIndex == 0) {
            throw new IllegalStateException();
        }
        linkedList.remove(nextIndex-1);
        nextIndex--;
    }
}