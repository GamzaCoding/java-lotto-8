package lotto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    @DisplayName("로또 번호 6개 일치시 FIRST_RANK")
    void 로또_번호_6개_일치시_FIRST_RANK() {
        //given
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);

        Rank expectRank = Rank.FIRST;
        //when
        Rank actualRank = winningLotto.calculateRank(lotto);

        //then
        Assertions.assertThat(expectRank).isEqualTo(actualRank);
    }

    @Test
    @DisplayName("로또 번호 5개 일치및_보너스번호_일치 시_SECOND_RANK")
    void 로또_번호_5개_일치및_보너스번호_일치_시_SECOND_RANK() {
        //given
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 10));
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);

        Rank expectRank = Rank.SECOND;
        //when
        Rank actualRank = winningLotto.calculateRank(lotto);

        //then
        Assertions.assertThat(expectRank).isEqualTo(actualRank);
    }

    @Test
    @DisplayName("로또 번호 5개 일치및 보너스번호 미일치 시 THIRD_RANK")
    void 로또_번호_5개_일치및_보너스번호_미일치_시_THIRD_RANK() {
        //given
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(List.of(1, 2, 3, 4, 5, 7), 10);

        Rank expectRank = Rank.THIRD;
        //when
        Rank actualRank = winningLotto.calculateRank(lotto);

        //then
        Assertions.assertThat(expectRank).isEqualTo(actualRank);
    }

    @Test
    @DisplayName("로또 번호 4개 일치시 FOURTH_RANK")
    void 로또_번호_4개_일치시_FOURTH_RANK() {
        //given
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(List.of(1, 2, 3, 4, 11, 12), 10);

        Rank expectRank = Rank.FOURTH;
        //when
        Rank actualRank = winningLotto.calculateRank(lotto);

        //then
        Assertions.assertThat(expectRank).isEqualTo(actualRank);
    }

    @Test
    @DisplayName("로또 번호 3개 일치시 FIFTh_RANK")
    void 로또_번호_3개_일치시_FIFTh_RANK() {
        //given
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 11, 12, 13));
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);

        Rank expectRank = Rank.FIFTH;
        //when
        Rank actualRank = winningLotto.calculateRank(lotto);

        //then
        Assertions.assertThat(expectRank).isEqualTo(actualRank);
    }

    @Test
    @DisplayName("로또 번호 2개 일치시 ZERO_RANK")
    void 로또_번호_2개_일치시_ZERO_RANK() {
        //given
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 11, 12, 13, 14));
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);

        Rank expectRank = Rank.ZER0;
        //when
        Rank actualRank = winningLotto.calculateRank(lotto);

        //then
        Assertions.assertThat(expectRank).isEqualTo(actualRank);
    }

    @Test
    @DisplayName("로또 번호 1개 일치시 ZERO_RANK")
    void 로또_번호_1개_일치시_ZERO_RANK() {
        //given
        Lotto lotto = Lotto.makeLotto(List.of(1, 11, 12, 13, 14, 15));
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);

        Rank expectRank = Rank.ZER0;
        //when
        Rank actualRank = winningLotto.calculateRank(lotto);

        //then
        Assertions.assertThat(expectRank).isEqualTo(actualRank);
    }

    @Test
    @DisplayName("로또 번호 0개 일치시 ZERO_RANK")
    void 로또_번호_0개_일치시_ZERO_RANK() {
        //given
        Lotto lotto = Lotto.makeLotto(List.of(10, 11, 12, 13, 14, 15));
        WinningLotto winningLotto = WinningLotto.makeWinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);

        Rank expectRank = Rank.ZER0;
        //when
        Rank actualRank = winningLotto.calculateRank(lotto);

        //then
        Assertions.assertThat(expectRank).isEqualTo(actualRank);
    }
}
