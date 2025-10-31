package lotto.service;

import lotto.model.Lottos;

public class LottoTotalService {
    private final Lottos lottos;

    public LottoTotalService(long inputPurchaseAmount) {
        this.lottos = createLottos(inputPurchaseAmount);
    }

    private static Lottos createLottos(long inputPurchaseAmount) {
        long lottoCount = inputPurchaseAmount / 1_000;

        return Lottos.createRandomLottos(lottoCount);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
