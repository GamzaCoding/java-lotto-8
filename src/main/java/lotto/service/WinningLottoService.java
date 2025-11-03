package lotto.service;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.dto.WinningLottoDto;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningLotto;

public class WinningLottoService {

    public static final int DEFAULT_COUNT = 0;
    public static final int ONE_COUNT = 1;

    public Map<Rank, Integer> calculateRankCount(WinningLotto winningLotto, Lottos lottos) {
        Map<Rank, Integer> rankCountStatistics = initializeRankCountStatistics();

        lottos.getLottos().stream()
                .map(lotto -> calculateRank(winningLotto, lotto))
                .filter(rank -> rank != Rank.NOTHING)
                .forEach(rank -> rankCountStatistics.merge(rank, ONE_COUNT, Integer::sum));

        return rankCountStatistics;
    }

    public Rank calculateRank(WinningLotto winningLotto, Lotto lotto) {
        int matchCount = lotto.countMatchWith(winningLotto);
        boolean matchBonus = lotto.checkBonusWith(winningLotto);
        return Rank.findByCount(matchCount, matchBonus);
    }

    private static Map<Rank, Integer> initializeRankCountStatistics() {
        Map<Rank, Integer> rankCountStatistics = new LinkedHashMap<>();
        Rank.getRanks()
                .forEach(rank -> rankCountStatistics.put(rank, DEFAULT_COUNT));
        return rankCountStatistics;
    }

    public WinningLotto convertToWinningLotto(WinningLottoDto winningLottoDto) {
        return WinningLotto.of(winningLottoDto.winningNumbers(), winningLottoDto.bonusNumber());
    }
}
