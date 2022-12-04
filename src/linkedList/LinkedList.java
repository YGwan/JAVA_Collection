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
}
