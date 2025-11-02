package lotto.service;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.dto.WinningLottoDto;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningLotto;

public class WinningLottoService {

    public Map<Rank, Integer> calculate(WinningLotto winningLotto, Lottos lottos) {
        Map<Rank, Integer> rankAndCount = new LinkedHashMap<>();

        rankAndCount.put(Rank.FIFTH, 0);
        rankAndCount.put(Rank.FOURTH, 0);
        rankAndCount.put(Rank.THIRD, 0);
        rankAndCount.put(Rank.SECOND, 0);
        rankAndCount.put(Rank.FIRST, 0);

        lottos.getLottos().stream()
                .forEach(lotto -> rankAndCount.merge(calculateRank(winningLotto, lotto), 1, Integer::sum));

        rankAndCount.remove(Rank.NOTHING);

        return rankAndCount;
    }

    public Rank calculateRank(WinningLotto winningLotto, Lotto lotto) {
        int matchCount = calculateMatchCount(winningLotto, lotto);
        boolean matchBonus = checkBonus(winningLotto, lotto);
        return Rank.findByCount(matchCount, matchBonus);
    }

    private int calculateMatchCount(WinningLotto winningLotto, Lotto lotto) {
        return winningLotto.calculateMatchCount(lotto);
    }

    private boolean checkBonus(WinningLotto winningLotto, Lotto lotto) {
        return winningLotto.checkBonus(lotto);
    }

    public WinningLotto change(WinningLottoDto winningLottoDto) {
        return WinningLotto.of(winningLottoDto.winningNumbers(), winningLottoDto.bonusNumber());
    }
}
