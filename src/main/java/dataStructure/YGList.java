package dataStructure;

public interface YGList<T> {

    int size();

    void add(int index, T input);

    void add(T input);

    void addFirst(T input);

    void addLast(T input);

    void remove();

    void remove(int index);

    void removeLast();

    void clear();

    boolean contains(T input);

    void reverse();

    T get(int index);

    int indexOf(T data);

    String toString();

}
