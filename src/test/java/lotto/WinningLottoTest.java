package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("로또 번호 6개 전부 일치한다.")
    void 로또_번호_6개_전부_일치한다() {
        //given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int expectMatchCount = 6;
        //when
        int matchCount = winningLotto.calculate(lotto);
        //then
        Assertions.assertThat(matchCount).isEqualTo(expectMatchCount);
    }

    @Test
    @DisplayName("로또 번호 5개가 일치한다.")
    void 로또_번호_5개가_일치한다() {
        //given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,45);
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int expectMatchCount = 5;
        //when
        int matchCount = winningLotto.calculate(lotto);
        //then
        Assertions.assertThat(matchCount).isEqualTo(expectMatchCount);
    }

    @Test
    @DisplayName("로또 번호 4개가 일치한다.")
    void 로또_번호_4개가_일치한다() {
        //given
        List<Integer> winningNumbers = List.of(1,2,3,4,44,45);
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int expectMatchCount = 4;
        //when
        int matchCount = winningLotto.calculate(lotto);
        //then
        Assertions.assertThat(matchCount).isEqualTo(expectMatchCount);
    }
}
