package lotto;

import lotto.util.RateOfReturnCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateOfReturnTest {

    @Test
    @DisplayName("총 수익률을 알려준다")
    void 총_수익률을_알려준다() {
        //given
        long inputLottoPurchaseMoney = 3_000;
        long totalLottoWinningAmount = 2_031_500_000;
        double expectedRateOfReturn = 677165.7;

        //when
        double rateOfReturn = RateOfReturnCalculator.calculateRateOfReturn(inputLottoPurchaseMoney, totalLottoWinningAmount);

        //then
        Assertions.assertThat(expectedRateOfReturn).isEqualTo(rateOfReturn);
    }
}
