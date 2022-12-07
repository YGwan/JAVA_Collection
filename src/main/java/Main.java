import ArrayList.YGArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("############ List Implementation ############");
        YGArrayList numbers = new YGArrayList(10);
        System.out.println(numbers.elementData.length);
        numbers.addFirst(0);
        numbers.addLast(10);
        numbers.add(1, 15);
        numbers.add(3,15);
        numbers.add(20);
        System.out.println();
        System.out.println(numbers);
        System.out.println();
        System.out.println(numbers.elementData.length);
    }
}
