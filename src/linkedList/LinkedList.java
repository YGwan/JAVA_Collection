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
}
