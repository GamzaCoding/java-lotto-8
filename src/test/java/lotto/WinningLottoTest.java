package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
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
        assertThat(matchCount).isEqualTo(expectMatchCount);
    }

    @Test
    @DisplayName("로또 번호 5개가 일치한다_보너스_번호_일치")
    void 로또_번호_5개가_일치한다_보너스_번호_일치() {
        //given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,45);
        int bonusNumber = 10;

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));

        int expectMatchCount = 5;
        boolean expectBonusCorrect = true;

        //when
        int matchCount = winningLotto.calculate(lotto);
        boolean bonusCorrect = winningLotto.checkBonus(lotto);

        //then
        assertThat(expectMatchCount).isEqualTo(matchCount);
        assertThat(expectBonusCorrect).isEqualTo(bonusCorrect);
    }

    @Test
    @DisplayName("로또 번호 5개가 일치한다_보너스_번호_불일치")
    void 로또_번호_5개가_일치한다_보너스_번호_불일치() {
        //given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,45);
        int bonusNumber = 10;

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int expectMatchCount = 5;
        boolean expectBonusCorrect = false;

        //when
        int matchCount = winningLotto.calculate(lotto);
        boolean bonusCorrect = winningLotto.checkBonus(lotto);

        //then
        assertThat(expectMatchCount).isEqualTo(matchCount);
        assertThat(expectBonusCorrect).isEqualTo(bonusCorrect);
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
        assertThat(matchCount).isEqualTo(expectMatchCount);
    }

    @Test
    @DisplayName("로또 번호 3개가 일치한다.")
    void 로또_번호_3개가_일치한다() {
        //given
        List<Integer> winningNumbers = List.of(1,2,3,43,44,45);
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int expectMatchCount = 3;
        //when
        int matchCount = winningLotto.calculate(lotto);
        //then
        assertThat(matchCount).isEqualTo(expectMatchCount);
    }

    @Test
    @DisplayName("로또 번호 2개가 일치한다.")
    void 로또_번호_2개가_일치한다() {
        //given
        List<Integer> winningNumbers = List.of(1,2,42,43,44,45);
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int expectMatchCount = 2;
        //when
        int matchCount = winningLotto.calculate(lotto);
        //then
        assertThat(matchCount).isEqualTo(expectMatchCount);
    }

    @Test
    @DisplayName("로또 번호 1개가 일치한다.")
    void 로또_번호_1개가_일치한다() {
        //given
        List<Integer> winningNumbers = List.of(1,41,42,43,44,45);
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int expectMatchCount = 1;
        //when
        int matchCount = winningLotto.calculate(lotto);
        //then
        assertThat(matchCount).isEqualTo(expectMatchCount);
    }

    @Test
    @DisplayName("로또 번호 일치하는게 없다.")
    void 로또_번호_일치하는게_없다() {
        //given
        List<Integer> winningNumbers = List.of(40,41,42,43,44,45);
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int expectMatchCount = 0;
        //when
        int matchCount = winningLotto.calculate(lotto);
        //then
        assertThat(matchCount).isEqualTo(expectMatchCount);
    }

    // winning 로또 번호화 보너스 번호가 중복되는 지 테스트
}
