package linkedList;

public class LinkedListMain {

    public static void main(String[] args) {
        System.out.println("############ LinkedList ############");
        LinkedList numbers = new LinkedList();
        numbers.addFirst(1);
        numbers.addLast(2);
        numbers.add(1,8);
        System.out.println(numbers);
        numbers.remove(1);
        System.out.println(numbers);
        numbers.removeLast();
        System.out.println(numbers);
    }
}
