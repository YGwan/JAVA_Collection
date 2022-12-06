package linkedList;

class Node<T> {

    private final T data;
    private Node<T> next;

    public Node(T input) {
        this.data = input;
        this.next = null;
    }

    public Node<T> next() {
        return next;
    }

    public void updateNext(Node<T> next) {
        this.next = next;
    }

    public T data() {
        return data;
    }
}
