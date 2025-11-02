package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("로또 번호 6개 전부 일치한다.")
    void 로또_번호_6개_전부_일치한다() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int expectMatchCount = 6;
        int actualMatchCount = winningLotto.calculateMatchCount(lotto);

        //then
        assertThat(expectMatchCount).isEqualTo(actualMatchCount);
    }

    @Test
    @DisplayName("로또 번호 5개가 일치한다_보너스_번호_일치")
    void 로또_번호_5개가_일치한다_보너스_번호_일치() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
        int bonusNumber = 10;
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(winningNumbers, bonusNumber);

        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 10));

        //when
        int expectMatchCount = 5;
        boolean expectBonusCorrect = true;
        int actualMatchCount = winningLotto.calculateMatchCount(lotto);
        boolean actualBonusCorrect = winningLotto.checkBonus(lotto);

        //then
        assertThat(expectMatchCount).isEqualTo(actualMatchCount);
        assertThat(expectBonusCorrect).isEqualTo(actualBonusCorrect);
    }

    @Test
    @DisplayName("로또 번호 5개가 일치한다_보너스_번호_불일치")
    void 로또_번호_5개가_일치한다_보너스_번호_불일치() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
        int bonusNumber = 10;

        WinningLotto winningLotto = WinningLotto.makeWinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int expectMatchCount = 5;
        boolean expectBonusCorrect = false;
        int actualMatchCount = winningLotto.calculateMatchCount(lotto);
        boolean actualBonusCorrect = winningLotto.checkBonus(lotto);

        //then
        assertThat(expectMatchCount).isEqualTo(actualMatchCount);
        assertThat(expectBonusCorrect).isEqualTo(actualBonusCorrect);
    }

    @Test
    @DisplayName("로또 번호 4개가 일치한다.")
    void 로또_번호_4개가_일치한다() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 44, 45);
        int bonusNumber = 10;
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int expectMatchCount = 4;
        int actualMatchCount = winningLotto.calculateMatchCount(lotto);

        //then
        assertThat(expectMatchCount).isEqualTo(actualMatchCount);
    }

    @Test
    @DisplayName("로또 번호 3개가 일치한다.")
    void 로또_번호_3개가_일치한다() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 43, 44, 45);
        int bonusNumber = 10;
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int expectMatchCount = 3;
        int actualMatchCount = winningLotto.calculateMatchCount(lotto);

        //then
        assertThat(expectMatchCount).isEqualTo(actualMatchCount);
    }

    @Test
    @DisplayName("로또 번호 2개가 일치한다.")
    void 로또_번호_2개가_일치할때_꼴등() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 42, 43, 44, 45);
        int bonusNumber = 10;
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int expectMatchCount = 2;
        int actualMatchCount = winningLotto.calculateMatchCount(lotto);

        //then
        assertThat(expectMatchCount).isEqualTo(actualMatchCount);
    }

    @Test
    @DisplayName("로또 번호 1개가 일치한다.")
    void 로또_번호_1개가_일치할때_꼴등() {
        //given
        List<Integer> winningNumbers = List.of(1, 41, 42, 43, 44, 45);
        int bonusNumber = 10;
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int expectMatchCount = 1;
        int actualMatchCount = winningLotto.calculateMatchCount(lotto);

        //then
        assertThat(expectMatchCount).isEqualTo(actualMatchCount);
    }

    @Test
    @DisplayName("로또 번호 일치하는게 없다.")
    void 로또_번호_일치하는게_없다() {
        //given
        List<Integer> winningNumbers = List.of(40, 41, 42, 43, 44, 45);
        int bonusNumber = 10;
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        int expectMatchCount = 0;
        int actualMatchCount = winningLotto.calculateMatchCount(lotto);

        //then
        assertThat(expectMatchCount).isEqualTo(actualMatchCount);
    }

    @Test
    @DisplayName("당첨 로또 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    void 당첨_로또_번호와_보너스_번호가_중복되면_예외가_발생한다() {

        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;

        // then
        assertThatThrownBy(() -> WinningLotto.makeWinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
