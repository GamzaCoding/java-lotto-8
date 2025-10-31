package lotto.dto;

import java.util.List;
import lotto.Lotto;
import lotto.Lottos;

public class PurchasedLottosDto {
    private final Lottos lottos;

    public PurchasedLottosDto(Lottos lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }
}
