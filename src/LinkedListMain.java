import linkedList.ListIterator;
import linkedList.YGLinkedList;

public class LinkedListMain {

    public static void main(String[] args) {
        System.out.println("############ LinkedList ############");
        YGLinkedList<Integer> numbers = new YGLinkedList<>();
        numbers.add(10);
        System.out.println(numbers);
        numbers.remove(0);
        System.out.println(numbers);
    }
}
