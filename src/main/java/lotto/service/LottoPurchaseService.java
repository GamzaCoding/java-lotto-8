package lotto.service;

import java.util.List;
import lotto.dto.ResponseLottosDto;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottoPurchaseService {
    public static final int AMOUNT_OF_ONE_LOTTO = 1_000;

    public Lottos purchaseLottos(long inputPurchaseAmount) {
        int lottoCount = getLottoCount(inputPurchaseAmount);
        return Lottos.generate(lottoCount);
    }

    public Lottos convertToLottos(ResponseLottosDto responseLottosDto) {
        List<Lotto> lottos = responseLottosDto.lottos().stream()
                .map(innerLotto -> Lotto.manualLotto(innerLotto.numbers()))
                .toList();
        return Lottos.of(lottos);
    }

    private int getLottoCount(long inputPurchaseAmount) {
        return (int)inputPurchaseAmount / AMOUNT_OF_ONE_LOTTO;
    }
}
