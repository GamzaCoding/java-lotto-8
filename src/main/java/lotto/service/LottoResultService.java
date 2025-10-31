package lotto.service;

import lotto.dto.LottoResultDto;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;

public class LottoResultService {
    private final Lottos lottos;
    private final WinningLotto winningLotto;
    private final LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();

    public LottoResultService(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public long calculateTotalWinningAmount() {
        return lottos.getLottos().stream()
                .map(this::createLottoResultDto)
                .map(lottoResultCalculator::calculateResultAmount)
                .mapToLong(Long::longValue)
                .sum();
    }

    private LottoResultDto createLottoResultDto(Lotto lotto) {
        return new LottoResultDto(winningLotto.calculateMatchCount(lotto), winningLotto.checkBonus(lotto));
    }
}
