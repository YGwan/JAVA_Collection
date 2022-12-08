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
        numbers.add(null);
        System.out.println(numbers);
        ArrayList<Integer> a = new ArrayList<>();
    }
}
