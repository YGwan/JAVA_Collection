package ygArrayList;

import dataStructure.arrayList.ListIterator;
import dataStructure.arrayList.YGArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class IteratorTest {

    private final YGArrayList<Integer> numbers = new YGArrayList<>(List.of(1, 2, 3, 4, 5));
    private final int size = numbers.size();

    @DisplayName("YGArrayList에 해당하는 ListIterator을 생성한다.")
    @Test
    public void createYGArrayListIterator() {
        ListIterator<Integer> listIterator = numbers.listIterator();
        assertThat(listIterator).isExactlyInstanceOf(ListIterator.class);
    }

    @DisplayName("ListIterator의 Next 관련 메서드를 사용한다.")
    @Nested
    class UseNextServiceYGArrayListIterator {

        @DisplayName("next 메서드를 사용해 numbers 값을 가져온다.")
        @Test
        public void useNext() {
            ListIterator<Integer> listIterator = numbers.listIterator();
            for (int value = 1; value <= size; value++) {
                assertThat(listIterator.next()).isEqualTo(value);
            }
        }

        @DisplayName("hasNext가 값이 있을 경우 true를 리턴하고 값이 없을경우 false를 리턴하는지 확인한다.")
        @Test
        public void useHasNext() {
            ListIterator<Integer> listIterator = numbers.listIterator();
            for (int order = 0; order < size; order++) {
                assertThat(listIterator.hasNext()).isTrue();
                listIterator.next();
            }
            assertThat(listIterator.hasNext()).isFalse();
        }
    }

    @DisplayName("ListIterator의 Previous 관련 메서드를 사용한다.")
    @Nested
    class UsePreviousServiceYGArrayListIterator {

        @DisplayName("previous 메서드를 사용해 numbers 값을 가져온다.")
        @Test
        public void usePrevious() {
            ListIterator<Integer> listIterator = numbers.listIterator();
            for (int value = 0; value < size; value++) {
                listIterator.next();
            }
            for (int value = size; value > 0; value--) {
                assertThat(listIterator.previous()).isEqualTo(value);
            }
        }

        @DisplayName("hasPrevious가 값이 있을 경우 true를 리턴하고 값이 없을경우 false를 리턴하는지 확인한다.")
        @Test
        public void useHasPrevious() {
            ListIterator<Integer> listIterator = numbers.listIterator();
            for (int order = 0; order < size; order++) {
                listIterator.next();
            }
            for (int order = 0; order < size; order++) {
                assertThat(listIterator.hasPrevious()).isTrue();
                listIterator.previous();
            }
            assertThat(listIterator.hasPrevious()).isFalse();
        }
    }

    @DisplayName("ListIterator의 값을 제거한다.")
    @Nested
    class UseRemoveServiceYGArrayListIterator {

        @DisplayName("nextIndex가 0일 경우 IllegalStateException 에러를 발생시키는지 확인한다.")
        @Test
        public void useRemoveCreateError() {
            ListIterator<Integer> listIterator = numbers.listIterator();
            assertThatThrownBy(listIterator::remove)
                    .isInstanceOf(IllegalStateException.class);
        }

        @DisplayName("nextIndex가 0이 아닐 경우 값을 제거한다.")
        @Test
        public void useRemoveCorrect() {
            ListIterator<Integer> listIterator = numbers.listIterator();
            listIterator.next();
            listIterator.remove();
            assertThat(numbers).containsExactly(2, 3, 4, 5);
        }

        @DisplayName("hasNext, next, remove를 사용해서 전체를 삭제한다.")
        @Test
        public void allRemoveNumbersUseNext() {
            ListIterator<Integer> listIterator = numbers.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next();
                listIterator.remove();
            }
            assertThat(numbers).containsExactly();
        }
    }
}