package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    @DisplayName("로또 번호 6개 일치시 FIRST_RANK")
    void 로또_번호_6개_일치시_FIRST_RANK() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);

        Rank expectRank = Rank.FIRST;
        //when
        Rank actualRank = winningLotto.calulateRank(lotto);

        //then
        Assertions.assertThat(expectRank).isEqualTo(actualRank);
    }
}
