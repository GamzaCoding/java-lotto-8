package lotto.model;

import java.util.List;
import java.util.stream.LongStream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos); // 얕은 복사 같은데.. 흠...
    }

    public static Lottos createRandomLottos(long count) {
        List<Lotto> lottosByRandom = LongStream
                .range(0, count)
                .mapToObj(i -> Lotto.createRandomLotto())
                .toList();

        return new Lottos(lottosByRandom);
    }

    public static Lottos makeLottos(List<Lotto> lottos) {
        return new Lottos(lottos);
    }
}
