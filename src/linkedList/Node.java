package linkedList;

class Node {

    final Object data;
    Node next;

    public Node(Object input) {
        this.data = input;
        this.next = null;
    }

    public String toString() {
        return String.valueOf(this.data);
    }
}
