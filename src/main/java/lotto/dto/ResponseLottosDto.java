package lotto.dto;

import java.util.List;
import lotto.model.Lottos;

public record ResponseLottosDto(List<InnerLotto> lottos) {

    public static ResponseLottosDto of(Lottos lottos) {
        List<InnerLotto> responseLottos = lottos.getLottos().stream()
                .map(lotto -> InnerLotto.of(lotto.getNumbers()))
                .toList();
        return new ResponseLottosDto(List.copyOf(responseLottos));
    }

    public long getLottoCount() {
        return lottos.size();
    }

    public record InnerLotto(List<Integer> numbers) {

        private static InnerLotto of(List<Integer> numbers) {
            return new InnerLotto(List.copyOf(numbers));
        }
    }
}
