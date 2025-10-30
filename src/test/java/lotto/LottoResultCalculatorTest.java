package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultCalculatorTest {

    @Test
    @DisplayName("1등 당첨 금액을 구한다.")
    void _1등_당첨_금액을_구한다() {
        //given
        int lottoMatchCount = 6;
        boolean bonusCorrect = false;
        LottoResultDto lottoResultDto = new LottoResultDto(lottoMatchCount, bonusCorrect);
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
        long expectResultAmount = 2_000_000_000;

        //when
        long resultAmount = lottoResultCalculator.calculateResultAmount(lottoResultDto);

        //then
        assertThat(expectResultAmount).isEqualTo(resultAmount);
    }

    @Test
    @DisplayName("2등 당첨 금액을 구한다.")
    void _2등_당첨_금액을_구한다() {
        //given
        int lottoMatchCount = 5;
        boolean bonusCorrect = true;
        LottoResultDto lottoResultDto = new LottoResultDto(lottoMatchCount, bonusCorrect);
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
        long expectResultAmount = 30_000_000;

        //when
        long resultAmount = lottoResultCalculator.calculateResultAmount(lottoResultDto);

        //then
        assertThat(expectResultAmount).isEqualTo(resultAmount);
    }

    @Test
    @DisplayName("3등 당첨 금액을 구한다.")
    void _3등_당첨_금액을_구한다() {
        //given
        int lottoMatchCount = 5;
        boolean bonusCorrect = false;
        LottoResultDto lottoResultDto = new LottoResultDto(lottoMatchCount, bonusCorrect);
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
        long expectResultAmount = 1_500_000;

        //when
        long resultAmount = lottoResultCalculator.calculateResultAmount(lottoResultDto);

        //then
        assertThat(expectResultAmount).isEqualTo(resultAmount);
    }
}
