package linkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {

        private final Object data;
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        Node newNode = new Node(input);
        if (size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    private Node node(int index) {
        Node node = head;
        for (int order = 0; order < index; order++) {
            node = node.next;
        }
        return node;
    }

    public void add(int list, Object input) {
        if (list == 0) {
            addFirst(input);
        } else {
            Node previousNode = node(list - 1);
            Node subsequentNode = previousNode.next;
            Node newNode = new Node(input);
            previousNode.next = newNode;
            newNode.next = subsequentNode;
            size++;
        }
    }

    public void removeFirst() {
        head = head.next;
        size--;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
        }
        Node previousNode = node(index - 1);
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

    public int size() {
        return size;
    }

    public Object get(int index) {
        return node(index).data;
    }

    public int indexOf(Object data) {
        for (int index = 0; index < size; index++) {
            if (node(index).data == data) {
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

    public ListIterator listIterator() {
        return new ListIterator();
    }

    class ListIterator {

        private Node next;
        private Node previousNode;
        private int nextIndex = 0;

        ListIterator() {
            next = head;
        }
    }
}
