package lotto.service;

import static lotto.constant.Constant.DEFAULT_COUNT;
import static lotto.constant.Constant.ONE_COUNT;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.dto.WinningLottoDto;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningLotto;

public class WinningLottoService {

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
