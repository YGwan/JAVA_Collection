package ygArrayList;

import dataStructure.arrayList.YGArrayList;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTest {

    private final List<Integer> originalNumbers = List.of(1, 2, 3, 4, 5);

    @DisplayName("YGArrayList를 생성/초기화한다.")
    @Test
    public void createYGArrayList() {
        YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
        assertThat(numbers).isExactlyInstanceOf(YGArrayList.class);
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5);
    }

    @DisplayName("YGArrayList에 값을 추가한다.")
    @Nested
    class AddYGArrayList {

        private final int inputData = 6;

        @DisplayName("리스트의 시작점에 값을 추가한다.")
        @Test
        public void addFirstYGArrayList() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            numbers.addFirst(inputData);
            assertThat(numbers.get(0)).isEqualTo(inputData);
        }

        @DisplayName("리스트의 끝점에 값을 추가한다.")
        @Test
        public void addLastYGArrayList() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            numbers.addLast(inputData);
            assertThat(numbers.get(numbers.size() - 1)).isEqualTo(inputData);

            numbers.add(inputData);
            assertThat(numbers.get(numbers.size() - 1)).isEqualTo(inputData);
        }

        @DisplayName("인덱스 위치에 값을 추가한다.")
        @Test
        public void addIndexPointYGArrayList() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            int inputIndex = 2;
            numbers.add(inputIndex, inputData);
            assertThat(numbers.get(inputIndex)).isEqualTo(inputData);
        }
    }

    @DisplayName("YGArrayList에 값을 제거한다.")
    @Nested
    class RemoveYGArrayList {

        @DisplayName("리스트 첫번째 값을 제거한다.")
        @Test
        public void removeFirstYGArrayList() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            numbers.remove();
            assertThat(numbers).containsExactly(2, 3, 4, 5);
        }

        @DisplayName("리스트의 마지막 값을 제거한다.")
        @Test
        public void removeLastYGArrayList() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            numbers.removeLast();
            assertThat(numbers).containsExactly(1, 2, 3, 4);
        }

        @DisplayName("인덱스 위치에 값을 제거한다.")
        @Test
        public void removeIndexPointYGArrayList() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            int inputIndex = 3;
            numbers.remove(inputIndex);
            assertThat(numbers).containsExactly(1, 2, 3, 5);
        }

        @DisplayName("값을 제거한다.")
        @Test
        public void removeValueYGArrayList() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            int inputValue = 5;
            numbers.remove(Integer.valueOf(inputValue));
            assertThat(numbers).containsExactly(1, 2, 3, 4);
        }
    }

    @DisplayName("YGArrayList의 정보를 반환한다.")
    @Nested
    class UseServiceYGArrayList {

        private final int inputIndex = 0;
        private final int inputIndexOfData = 1;

        @DisplayName("리스트의 크기 값을 반환한다.")
        @Test
        public void useSize() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            assertThat(numbers.size()).isEqualTo(originalNumbers.size());
        }

        @DisplayName("리스트에 값이 있을 경우 True를 반환하는지 확인한다.")
        @Test
        public void useContainsTrueStatus() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            assertThat(numbers.contains(originalNumbers.get(0))).isTrue();
        }

        @DisplayName("리스트에 값이 없을 경우 False 반환하는지 확인한다.")
        @Test
        public void useContainsFalseStatus() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            assertThat(numbers.contains(Integer.MAX_VALUE)).isFalse();
        }

        @DisplayName("리스트의 역순으로 변환한다.")
        @Test
        public void useReverse() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            numbers.reverse();
            assertThat(numbers).containsExactly(5, 4, 3, 2, 1);
        }

        @DisplayName("인덱스의 값을 반환한다.")
        @Test
        public void useGet() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            assertThat(numbers.get(inputIndex)).isEqualTo(inputIndexOfData);
        }

        @DisplayName("값의 인덱스값을 반환한다.")
        @Test
        public void useIndexOf() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            assertThat(numbers.indexOf(inputIndexOfData)).isEqualTo(inputIndex);
        }

        @DisplayName("모든 ArrayList의 값이 다 제거되는지 확인한다.")
        @Test
        public void useClear() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            numbers.clear();
            assertThat(numbers).containsExactly();
        }
    }

    @DisplayName("출력을 확인한다.")
    @Nested
    class CheckPrint {
        private PrintStream standardOut;
        private OutputStream captor;

        @BeforeEach
        protected final void init() {
            standardOut = System.out;
            captor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captor));
        }

        @AfterEach
        protected final void printOutput() {
            System.setOut(standardOut);
            System.out.println(output());
        }

        protected final String output() {
            return captor.toString().trim();
        }

        @DisplayName("foreach를 사용한 출력을 확인한다.")
        @Test
        public void useForeach() {
            YGArrayList<Integer> numbers = new YGArrayList<>(originalNumbers);
            for (Integer number : numbers) {
                System.out.println(number);
            }
            assertEquals("1\n2\n3\n4\n5", output());
        }
    }
}
