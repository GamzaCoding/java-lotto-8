package lotto;

import java.util.List;

public class PurchasedLottosDto {
    private final Lottos lottos;

    public PurchasedLottosDto(Lottos lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }
}
