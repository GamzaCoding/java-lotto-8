package lotto.service;

import lotto.model.Lottos;

public class LottoPurchaseService {
    public static Lottos purchaseLottos(long inputPurchaseAmount) {
        long lottoCount = inputPurchaseAmount / 1_000;
        return Lottos.createRandomLottos(lottoCount);
    }
}
