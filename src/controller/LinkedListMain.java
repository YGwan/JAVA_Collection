package controller;

import linkedList.LinkedList;

public class LinkedListMain {

    public static void main(String[] args) {
        System.out.println("############ LinkedList ############");
        LinkedList numbers = new LinkedList();
        numbers.add(1);
        numbers.addLast(2);
        numbers.add(1,8);
        System.out.println(numbers);
        numbers.remove(1);
        System.out.println(numbers);
        numbers.remove();
        System.out.println(numbers);
    }
}