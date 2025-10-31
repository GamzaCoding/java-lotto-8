package lotto;

import lotto.service.RateOfReturnService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateOfReturnServiceTest {

    @Test
    @DisplayName("총 수익률을 알려준다")
    void 총_수익률을_알려준다() {
        //given
        RateOfReturnService rateOfReturnService = new RateOfReturnService();
        long inputLottoPurchaseMoney = 3_000;
        long totalLottoWinningAmount = 2_031_500_000;
        double expectedRateOfReturn = 677165.7;

        //when
        double rateOfReturn = rateOfReturnService.calculateRateOfReturn(inputLottoPurchaseMoney, totalLottoWinningAmount);

        //then
        Assertions.assertThat(expectedRateOfReturn).isEqualTo(rateOfReturn);
    }
}
