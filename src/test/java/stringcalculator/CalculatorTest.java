package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void Setup(){
        calculator = new Calculator();
    }

    @DisplayName("덧셈테스트")
    @Test
    void sumTest() {
        assertThat(Operate.findOperator("+").calculateNumbers(1, 2)).isEqualTo(3);
    }

    @DisplayName("뺄셈테스트")
    @Test
    void subtractionTest() {
        assertThat(Operate.findOperator("-").calculateNumbers(1, 2)).isEqualTo(-1);
    }

    @DisplayName("곱셈테스트")
    @Test
    void multiplicationTest() {
        assertThat(Operate.findOperator("*").calculateNumbers(1, 2)).isEqualTo(2);
    }

    @DisplayName("나눗셈테스트")
    @Test
    void divisionTest() {
        assertThat(Operate.findOperator("/").calculateNumbers(1, 2)).isEqualTo(0);
    }

    @DisplayName("null값 테스트")
    @Test
    void nullTest() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> calculator.finalCalculate(null));
    }

    @DisplayName("빈값 테스트")
    @Test
    void emptyTest() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> calculator.finalCalculate(""));
    }

    @DisplayName("사칙연산자 이외 문자 테스트")
    @Test
    void stringTest() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> calculator.finalCalculate("1 ."));
    }

    @DisplayName("수식 비정상종료 테스트")
    @Test
    void equationExceptionTest() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> calculator.finalCalculate("1 +"));
    }

    @DisplayName("계산기 테스트")
    @Test
    void calculatorTest() throws IllegalArgumentException {
        assertThat(calculator.finalCalculate("1 + 2 / 4 + 9 * 4 - 1")).isEqualTo(35);
    }
}
