package LinkedList;

import linkedList.ListIterator;
import linkedList.YGLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class Iterator_Test {

    List<Integer> originalNumbers = List.of(1, 2, 3, 4, 5);
    YGLinkedList<Integer> numbers;
    private ListIterator<Integer> listIterator;

    @DisplayName("YGLinkedList에 해당하는 ListIterator을 생성한다.")
    @Test
    public void createYGLI() {
        this.numbers = new YGLinkedList<>(originalNumbers);
        this.listIterator = numbers.listIterator();
        assertThat(listIterator).isExactlyInstanceOf(ListIterator.class);
    }

    @DisplayName("ListIterator의 메서드를 이용해본다..")
    @Nested
    class useServiceYGLI {

        private final int size = originalNumbers.size();

        @DisplayName("next가 잘 동작하는지 확인해본다.")
        @Test
        public void useNext() {
            createYGLI();
            for (int value = 1; value <= size; value++) {
                assertThat(listIterator.next()).isEqualTo(value);
            }
        }

        @DisplayName("hasNext가 잘 동작하는지 확인해본다.")
        @Test
        public void useHasNext() {
            createYGLI();
            for (int order = 0; order < size; order++) {
                assertThat(listIterator.hasNext()).isTrue();
                listIterator.next();
            }
            assertThat(listIterator.hasNext()).isFalse();
        }

        @DisplayName("nextIndex가 0일 경우 에러가 잘 발생하는지 확인해본다.")
        @Test
        public void useRemoveCreateError() {
            createYGLI();
            assertThatThrownBy(() -> listIterator.remove())
                    .isInstanceOf(IllegalStateException.class);
        }

        @DisplayName("nextIndex가 0이 아닐 경우 잘 제거되는지 확인해본다.")
        @Test
        public void useRemoveCorrect() {
            createYGLI();
            listIterator.next();
            listIterator.remove();
            assertThat(numbers).containsExactly(2, 3, 4, 5);
        }

        @DisplayName("hasNext, next, remove를 사용해서 전체를 삭제한다.")
        @Test
        public void allRemoveNumbers() {
            createYGLI();
            while (listIterator.hasNext()) {
                listIterator.next();
                listIterator.remove();
            }
            assertThat(numbers).containsExactly();
        }
    }
}
