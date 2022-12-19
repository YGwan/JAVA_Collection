package ygLinkedList;

import dataStructure.linkedList.YGLinkedList;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ListTest {

    private final List<Integer> originalNumbers = List.of(1, 2, 3, 4, 5);

    @DisplayName("YGLinkedList를 생성/초기화를 진행한다.")
    @Test
    public void createYGLinkedList() {
        YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
        assertThat(numbers).isExactlyInstanceOf(YGLinkedList.class);
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5);
    }

    @DisplayName("YGLinkedList에 값을 추가한다.")
    @Nested
    class AddYGLinkedList {

        private final int inputIndex = 2;
        private final int inputData = 6;

        @DisplayName("리스트의 시작점에 값을 추가한다.")
        @Test
        public void addFirstYGLinkedList() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.addFirst(inputData);
            assertThat(numbers.get(0)).isEqualTo(inputData);
        }

        @DisplayName("리스트의 끝점에 값을 추가한다.")
        @Test
        public void addLastYGLinkedList() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.addLast(inputData);
            assertThat(numbers.get(numbers.size() - 1)).isEqualTo(inputData);

            numbers.add(inputData);
            assertThat(numbers.get(numbers.size() - 1)).isEqualTo(inputData);
        }

        @DisplayName("인덱스 위치에 값을 추가한다.")
        @Test
        public void addIndexPointYGLinkedList() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.add(inputIndex, inputData);
            assertThat(numbers.get(inputIndex)).isEqualTo(inputData);
        }
    }

    @DisplayName("YGLinkedList에 값을 제거한다.")
    @Nested
    class RemoveYGLinkedList {
        @DisplayName("리스트의 시작점에 값을 제거한다.")
        @Test
        public void removeFirstYGLinkedList() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.remove();
            assertThat(numbers).containsExactly(2, 3, 4, 5);
        }

        @DisplayName("리스트의 끝점에 값을 제거한다.")
        @Test
        public void removeLastYGLinkedList() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.removeLast();
            assertThat(numbers).containsExactly(1, 2, 3, 4);
        }

        @DisplayName("인덱스 위치에 값을 제거한다.")
        @Test
        public void removeIndexPointYGLinkedList() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.remove(2);
            assertThat(numbers).containsExactly(1, 2, 4, 5);
        }
    }

    @DisplayName("YGLinkedList의 정보를 반환한다.")
    @Nested
    class UseServiceYGLinkedList {

        private final int inputIndex = 0;
        private final int inputIndexOfData = 1;

        @DisplayName("리스트의 크기 값을 확인한다.")
        @Test
        public void useSize() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            assertThat(numbers.size()).isEqualTo(originalNumbers.size());
        }

        @DisplayName("리스트에 값이 있을 경우 True를 반환하는지 확인한다.")
        @Test
        public void useContainsTrueStatus() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            assertThat(numbers.contains(originalNumbers.get(0))).isTrue();
        }

        @DisplayName("리스트에 값이 없을 경우 False 반환하는지 한다.")
        @Test
        public void useContainsFalseStatus() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            assertThat(numbers.contains(Integer.MAX_VALUE)).isFalse();
        }

        @DisplayName("리스트의 역순으로 변환한다.")
        @Test
        public void useReverse() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.reverse();
            assertThat(numbers).containsExactly(5, 4, 3, 2, 1);
        }

        @DisplayName("인덱스에 해당하는 값을 반환한다.")
        @Test
        public void useGet() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            assertThat(numbers.get(inputIndex)).isEqualTo(inputIndexOfData);
        }

        @DisplayName("인덱스에 해당하는 값이 잘 반환되는지 확인한다.")
        @Test
        public void useIndexOf() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            assertThat(numbers.indexOf(inputIndexOfData)).isEqualTo(inputIndex);
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
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            for (Integer number : numbers) {
                System.out.println(number);
            }
            assertEquals("1\n2\n3\n4\n5", output());
        }
    }
}