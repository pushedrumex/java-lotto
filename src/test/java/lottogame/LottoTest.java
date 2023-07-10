package lottogame;

import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다")
    @Test
    void 로또_객체_생성_실패_개수() {
        List<Integer> values = List.of(1, 2, 3, 5);
        Assertions.assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new Lotto(values))
            .withMessage("로또 번호는 6개여야합니다");
    }

    @DisplayName("로또 번호가 중복되면 예외가 발생한다")
    @Test
    void 로또_객체_생성_실패_중복() {
        List<Integer> values = List.of(1, 2, 3, 5, 5, 5);
        Assertions.assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new Lotto(values))
            .withMessage("로또 번호는 중복되지 않아야합니다");
    }

    @DisplayName("로또객체가 정상적으로 생성된다")
    @Test
    void 로또_객체_생성_성공() {
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6);
        assertThatNoException()
            .isThrownBy(() -> new Lotto(values));
    }

}