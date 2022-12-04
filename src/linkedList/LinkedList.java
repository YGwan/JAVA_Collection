package linkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    public void add(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        addSize();
        if (head.next == null) {
            tail = head;
        }
    }

    public void add(int list, Object input) {
        if (list == 0) {
            add(input);
        } else {
            Node previousNode = findNode(list - 1);
            Node subsequentNode = previousNode.next;
            Node newNode = new Node(input);
            previousNode.next = newNode;
            newNode.next = subsequentNode;
            addSize();
        }
    }

    public void addLast(Object input) {
        Node newNode = new Node(input);
        if (size == 0) {
            add(input);
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
        Node previousNode = findNode(index - 1);
        Node doDeletedNode = previousNode.next;
        previousNode.next = previousNode.next.next;
        if (doDeletedNode == tail) {
            tail = previousNode;
        }
        size--;
    }

    public void removeLast() {
        remove(size - 1);
    }

    public Node getHeadNode() {
        return head;
    }

    public void setHeadNode(Node newHeadNode) {
        head = newHeadNode;
    }

    public int size() {
        return size;
    }

    protected void addSize() {
        size++;
    }

    public Object get(int index) {
        return findNode(index).data;
    }

    public int indexOf(Object data) {
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
        Node node = head;
        StringBuilder str = new StringBuilder("[");

        while (node.next != null) {
            str.append(node.data).append(", ");
            node = node.next;
        }
        return str.append(node.data).append("]").toString();
    }

    private Node findNode(int index) {
        Node node = head;
        for (int order = 0; order < index; order++) {
            node = node.next;
        }
        return node;
    }

    public ListIterator listIterator() {
        return new ListIterator(LinkedList.this);
    }
}
