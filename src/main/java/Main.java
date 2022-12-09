import ArrayList.YGArrayList;

import java.util.ArrayList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        System.out.println("############ List Implementation ############");
        YGArrayList numbers = new YGArrayList(10);
        numbers.addFirst(0);
        numbers.addLast(10);
        numbers.add(1, 15);
        numbers.add(3,15);
        System.out.println(numbers);
        YGArrayList.ListIterator li = numbers.listIterator();
        while(li.hasNext()) {
            System.out.println(li.next());
        }
        System.out.println(li.previous());
        System.out.println(li.previous());
        System.out.println(li.previous());
        System.out.println(li.previous());

        ArrayList<Integer> a = new ArrayList<>();
        ListIterator<Integer> k = a.listIterator();
        k.remove();
    }
}
