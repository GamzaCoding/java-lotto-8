package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static Lottos createLottos(long count) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            lottos.add(Lotto.of());
        }

        return new Lottos(lottos);
    }
}
