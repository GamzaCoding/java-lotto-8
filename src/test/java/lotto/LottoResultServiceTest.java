package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultServiceTest {
    @Test
    @DisplayName("총 당첨 금액을 알려준다.")
    void 총_당첨_금액을_알려준다() {
        //given
        WinningLotto winningLotto = new WinningLotto(List.of(10, 20, 30, 40, 44, 45), 1);
        Lotto firstPriceLotto = new Lotto(List.of(10, 20, 30, 40, 44, 45));
        Lotto secondPriceLotto = new Lotto(List.of(10, 20, 30, 40, 44, 1));
        Lotto thirdPriceLotto = new Lotto(List.of(10, 20, 30, 40, 44, 2));

        Lottos lottos = new Lottos(List.of(firstPriceLotto, secondPriceLotto, thirdPriceLotto));
        LottoResultService lottoResultService = new LottoResultService(lottos, winningLotto);

        long expectTotalLottoWinningAmount = 2_031_500_000;

        //when
        long totalLottoWinningAmount = lottoResultService.calculateTotalWinningAmount();

        //then
        Assertions.assertThat(expectTotalLottoWinningAmount).isEqualTo(totalLottoWinningAmount);
    }
}
