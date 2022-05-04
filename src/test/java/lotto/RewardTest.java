package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {
    @ParameterizedTest
    @CsvSource(value = {"2:0", "3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void rewardOfWinShouldMatchWithPrice(String win, String price) {
        int winI = Integer.parseInt(win);
        int priceI = Integer.parseInt(price);
        assertThat(Reward.of(winI).value).isEqualTo(priceI);
    }
}