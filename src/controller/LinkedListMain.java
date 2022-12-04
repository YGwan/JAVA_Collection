package controller;

import linkedList.LinkedList;
import linkedList.ListIterator;

public class LinkedListMain {

    public static void main(String[] args) {
        System.out.println("############ LinkedList ############");
        LinkedList numbers = new LinkedList();
        numbers.add(10);
        numbers.addLast(2);
        numbers.add(1, 8);
        System.out.println(numbers);
        ListIterator i = numbers.listIterator();
        while (i.hasNext()) {
            if ((int) i.next() == 10)
                i.add(20);
        }
        i.remove();
        System.out.println(numbers);
        numbers.removeLast();
        System.out.println(numbers);
        System.out.println(numbers.size());
        System.out.println(numbers.get(0));
        System.out.println(numbers.indexOf(20));
    }
}
