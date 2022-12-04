package controller;

import linkedList.LinkedList;
import linkedList.ListIterator;

public class LinkedListMain {

    public static void main(String[] args) {
        System.out.println("############ LinkedList ############");
        LinkedList numbers = new LinkedList();
        numbers.addFirst(10);
        numbers.addLast(2);
        numbers.add(1, 8);
        numbers.add(2);
        numbers.removeLast();
        System.out.println(numbers);
        System.out.println("foreach 사용");
        for (Object number : numbers) {
            System.out.println(number);
        }
        System.out.println("ListIterator 사용");
        ListIterator listIterator = numbers.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        System.out.println("LinkedList 메서드 사용");
        System.out.println(numbers.size());
        System.out.println(numbers.get(0));
        System.out.println(numbers.indexOf(8));
    }
}
