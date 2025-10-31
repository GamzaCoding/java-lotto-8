package lotto.dto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class PurchasedLottosDto {
    private final Lottos lottos;

    public PurchasedLottosDto(Lottos lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }
}
