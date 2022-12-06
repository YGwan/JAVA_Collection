package LinkedList;

import linkedList.YGLinkedList;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class List_Test {

    List<Integer> originalNumbers = List.of(1, 2, 3, 4, 5);

    @DisplayName("YGLinkedList를 생성/초기화 진행.")
    @Test
    public void createYGL() {
        YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
        assertThat(numbers).isExactlyInstanceOf(YGLinkedList.class);
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5);
    }

    @DisplayName("YGLinkedList에 값을 추가해본다.")
    @Nested
    class addYGL {
        @DisplayName("해당 리스트의 시작점에 값을 추가해본다.")
        @Test
        public void addFirstYGL() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.addFirst(0);
            assertThat(numbers).containsExactly(0, 1, 2, 3, 4, 5);
        }

        @DisplayName("해당 리스트의 끝점에 값을 추가해본다.")
        @Test
        public void addLastYGL() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.addLast(6);
            assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);

            numbers.add(7);
            assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6, 7);
        }

        @DisplayName("해당 리스트의 인덱스에 따른 해당 지점에 값을 추가해본다.")
        @Test
        public void addIndexPointYGL() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.add(2, 6);
            assertThat(numbers).containsExactly(1, 2, 6, 3, 4, 5);
        }
    }

    @DisplayName("YGLinkedList에 값을 제거해본다.")
    @Nested
    class RemoveYGL {
        @DisplayName("해당 리스트의 시작점에 값을 제거해본다..")
        @Test
        public void removeFirstYGL() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.remove();
            assertThat(numbers).containsExactly(2, 3, 4, 5);
        }

        @DisplayName("해당 리스트의 끝점에 값을 제거해본다..")
        @Test
        public void removeLastYGL() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.removeLast();
            assertThat(numbers).containsExactly(1, 2, 3, 4);
        }

        @DisplayName("해당 리스트의 인덱스에 따른 해당 지점에 값을 제거해본다.")
        @Test
        public void removeIndexPointYGL() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.remove(2);
            assertThat(numbers).containsExactly(1, 2, 4, 5);
        }
    }

    @DisplayName("YGLinkedList의 메서드를 이용해본다..")
    @Nested
    class useServiceYGL {
        @DisplayName("해당 리스트의 크기 값을 확인한다.")
        @Test
        public void useSize() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            assertThat(numbers.size()).isEqualTo(5);
        }

        @DisplayName("해당 리스트의 값이 있을 경우 True를 반환하는지 확인해본다..")
        @Test
        public void useContainsTrueStatus() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            assertThat(numbers.contains(1)).isTrue();
        }

        @DisplayName("해당 리스트의 값이 없을 경우 False 반환하는지 확인해본다.")
        @Test
        public void useContainsFalseStatus() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            assertThat(numbers.contains(7)).isFalse();
        }

        @DisplayName("해당 리스트의 역순이 잘 작동되는지 확인해본다.")
        @Test
        public void useReverse() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            numbers.reverse();
            assertThat(numbers).containsExactly(5, 4, 3, 2, 1);
        }

        @DisplayName("해당 리스트의 인덱스에 해당하는 값이 잘 출력되는지 확인해본다.")
        @Test
        public void useGet() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            assertThat(numbers.get(1)).isEqualTo(2);
        }

        @DisplayName("해당 리스트의 인덱스에 해당하는 값이 잘 출력되는지 확인해본다.")
        @Test
        public void useIndexOf() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            assertThat(numbers.indexOf(3)).isEqualTo(2);
        }
    }

    @DisplayName("출력이 제대로 잘 되는지 확인한다.")
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

        @DisplayName("foreach를 사용해서 값을 조회해본다.")
        @Test
        public void useForeach() {
            YGLinkedList<Integer> numbers = new YGLinkedList<>(originalNumbers);
            for(Integer number : numbers) {
                System.out.println(number);
            }
            assertEquals("1\n2\n3\n4\n5", output());
        }
    }
}
