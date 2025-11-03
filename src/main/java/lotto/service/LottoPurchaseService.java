package lotto.service;

import static lotto.constant.Constant.AMOUNT_OF_ONE_LOTTO;

import java.util.List;
import lotto.dto.ResponseLottosDto;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.strategy.LottoNumberStrategy;
import lotto.model.strategy.RandomNumberStrategy;

public class LottoPurchaseService {

    private final LottoNumberStrategy lottoNumberStrategy;

    public LottoPurchaseService() {
        this.lottoNumberStrategy = new RandomNumberStrategy();
    }

    public Lottos purchaseLottos(long inputPurchaseAmount) {
        int lottoCount = getLottoCount(inputPurchaseAmount);
        return Lottos.generateAutomaticLottos(lottoCount, lottoNumberStrategy);
    }

    public Lottos convertToLottos(ResponseLottosDto responseLottosDto) {
        List<Lotto> lottos = responseLottosDto.lottos().stream()
                .map(innerLotto -> Lotto.manualLotto(innerLotto.numbers()))
                .toList();
        return Lottos.of(lottos);
    }

    private int getLottoCount(long inputPurchaseAmount) {
        return (int) inputPurchaseAmount / AMOUNT_OF_ONE_LOTTO;
    }
}
