package lotto.service;

import lotto.model.Lottos;

public class LottoPurchaseService {

    public Lottos buy(long inputPurchaseAmount) {
        long lottoCount = getLottoCount(inputPurchaseAmount);
        return Lottos.createRandomLottos(lottoCount);
    }

    private long getLottoCount(long inputPurchaseAmount) {
        return inputPurchaseAmount / 1_000;
    }
}
