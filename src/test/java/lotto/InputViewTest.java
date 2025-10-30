package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    @DisplayName("로또 구입 금액 입력이 숫자가 아닌 경우 예외 발생한다")
    void 로또_구입_금액_입력이_숫자가_아닌_경우_예외_발생_한다() {
        //given
        String inputLottoPurchaseMoney = "abcde";
        //then
        assertThatThrownBy(() -> Validation.valdateIsNumber(inputLottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
