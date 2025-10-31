package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validation.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    @DisplayName("로또 구입 금액 입력이 숫자가 아닌 경우 예외 발생한다")
    void 로또_구입_금액_입력이_숫자가_아닌_경우_예외_발생_한다() {
        //given
        String inputLottoPurchaseMoney = "abcde";
        //then
        assertThatThrownBy(() -> InputValidation.validateNumberValue(inputLottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액 입력이 음수인 경우 예외가 발생한다")
    void 로또_구입_금액_입력이_음수인_경우_예외가_발생한다() {
        //given
        String inputLottoPurchaseMoney = "-1000";
        //then
        assertThatThrownBy(() -> InputValidation.validateNegative(inputLottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액 입력이 0인 경우 예외가 발생한다")
    void 로또_구입_금액_입력이_0인_경우_예외가_발생한다() {
        //given
        String inputLottoPurchaseMoney = "0";
        //then
        assertThatThrownBy(() -> InputValidation.validateZeroNumber(inputLottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void 로또_구입_금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다() {
        //given
        String inputLottoPurchaseMoney = "1001";
        //then
        assertThatThrownBy(() -> InputValidation.validateDivisibleByThousand(inputLottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
