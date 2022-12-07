package ArrayList;

class Invalidator {

    protected static void notAppreciateValue(int initialCapacity) {
        throw new IllegalStateException(initialCapacity + "이 적절하지 않습니다..");
    }

    protected static void outOfIndexRange(int index, int size) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + "값이 범위에 벗어납니다.");
        }
    }
}
