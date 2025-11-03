package lotto.model;

import static lotto.util.Constant.START_INDEX;

import java.util.List;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generate(int count) {
        List<Lotto> lottosByRandom = IntStream
                .range(START_INDEX, count)
                .mapToObj(i -> Lotto.automaticLotto())
                .toList();

        return new Lottos(lottosByRandom);
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }
}
