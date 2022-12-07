package linkedList;

class Node<T> {

    private final T data;
    private Node<T> next;

    protected Node(T input) {
        this.data = input;
        this.next = null;
    }

    protected Node<T> next() {
        return next;
    }

    protected void updateNext(Node<T> next) {
        this.next = next;
    }

    protected boolean isSameData(T data) {
        return data().equals(data);
    }

    protected T data() {
        return data;
    }
}
