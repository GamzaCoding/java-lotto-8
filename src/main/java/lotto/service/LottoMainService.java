package lotto.service;

import lotto.dto.LottoResultDto;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.util.RateOfReturnCalculator;

public class LottoMainService {
    private final Lottos lottos;
    private final WinningLotto winningLotto;
    private final LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();

    public LottoMainService(Lottos lottos, WinningLotto winningLotto) {
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

    public double rateOfReturn(long inputLottoPurchaseMoney, long totalLottoWinningAmount) {
       return RateOfReturnCalculator.calculateRateOfReturn(inputLottoPurchaseMoney, totalLottoWinningAmount);
    }


    private LottoResultDto createLottoResultDto(Lotto lotto) {
        return new LottoResultDto(winningLotto.calculateMatchCount(lotto), winningLotto.checkBonus(lotto));
    }
}
