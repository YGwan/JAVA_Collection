import dataStructure.arrayList.YGArrayList;
import dataStructure.linkedList.YGLinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println("############ List Implementation ############");
        YGArrayList<Integer> numbers = new YGArrayList<>(10);
        numbers.addFirst(0);
        numbers.addLast(10);
        numbers.add(1, 15);
        numbers.add(3, 7);
        System.out.println(numbers);
        numbers.reverse();
        System.out.println(numbers);
        YGLinkedList<Integer> a = new YGLinkedList<>();
        a.add(10);
        a.add(20);
        a.add(30);
        a.add(40);
        a.clear();
        System.out.println(a);
    }
}
