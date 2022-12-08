package utils;

public class Invalidator {

    private final static String notAppreciateErrorMessage = "이 적절하지 않습니다..";
    private final static String outOfIndexErrorMessage = "값이 범위에 벗어납니다.";
    private final static String iteratorRemoveErrorMessage = "ListIterator가 가리키는 값이 없습니다.";

    public static void notAppreciateValue(int initialCapacity) {
        throw new IllegalStateException(initialCapacity + notAppreciateErrorMessage);
    }

    public static void outOfIndexRangeAdd(int index, int size) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + outOfIndexErrorMessage);
        }
    }

    public static void outOfIndexRange(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + outOfIndexErrorMessage);
        }
    }

    public static void iteratorRemoveNextIndexZero(int nextIndex) {
        if(nextIndex == 0) {
            throw new IllegalStateException(iteratorRemoveErrorMessage);
        }
    }
}
