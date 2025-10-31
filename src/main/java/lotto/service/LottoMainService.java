package lotto.service;

import lotto.dto.LottoResultDto;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;

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

    public static Lottos purchaseLottos(long inputPurchaseAmount) {
        long lottoCount = inputPurchaseAmount / 1_000;
        return Lottos.createRandomLottos(lottoCount);
    }

    private LottoResultDto createLottoResultDto(Lotto lotto) {
        return new LottoResultDto(winningLotto.calculateMatchCount(lotto), winningLotto.checkBonus(lotto));
    }
}
