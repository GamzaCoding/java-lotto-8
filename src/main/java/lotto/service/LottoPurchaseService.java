package lotto.service;

import java.util.List;
import lotto.dto.ResponseLottosDto;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottoPurchaseService {
    public static final int AMOUNT_OF_ONE_LOTTO = 1_000;

    public Lottos purchaseLottos(long inputPurchaseAmount) {
        long lottoCount = getLottoCount(inputPurchaseAmount);
        return Lottos.createRandomLottos(lottoCount);
    }

    public Lottos convertToLottos(ResponseLottosDto responseLottosDto) {
        List<Lotto> lottos = responseLottosDto.lottos().stream()
                .map(innerLotto -> Lotto.makeLotto(innerLotto.numbers()))
                .toList();
        return Lottos.makeLottos(lottos);
    }

    private long getLottoCount(long inputPurchaseAmount) {
        return inputPurchaseAmount / AMOUNT_OF_ONE_LOTTO;
    }
}
