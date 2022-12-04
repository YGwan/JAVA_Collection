package controller;

import linkedList.ListIterator;
import linkedList.YGLinkedList;

public class LinkedListMain {

    public static void main(String[] args) {
        System.out.println("############ LinkedList ############");
        YGLinkedList<Integer> ygLinkedList = new YGLinkedList<>();
        ygLinkedList.addFirst(10);
        ygLinkedList.addLast(2);
        ygLinkedList.add(1, 8);
        ygLinkedList.addFirst(2);
        ygLinkedList.removeLast();
        System.out.println(ygLinkedList);

        System.out.println("foreach 사용");
        for (Integer number : ygLinkedList) {
            System.out.println(number);
        }

        System.out.println("ListIterator 사용");
        ListIterator listIterator = ygLinkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("LinkedList 메서드 사용");
        System.out.println(ygLinkedList.size());
        System.out.println(ygLinkedList.get(0));
        System.out.println(ygLinkedList.indexOf(8));
    }
}
