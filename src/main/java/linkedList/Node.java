package linkedList;

class Node<T> {

    final T data;
    Node<T> next;

    public Node(T input) {
        this.data = input;
        this.next = null;
    }
}
