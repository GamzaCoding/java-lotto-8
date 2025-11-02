package lotto.dto;

import java.util.List;
import lotto.model.Lottos;

public class ResponseLottosDto {
    private final List<InnerLotto> responseLottos;

    private ResponseLottosDto(List<InnerLotto> responseLottos) {
        this.responseLottos = responseLottos;
    }

    public static ResponseLottosDto of(Lottos lottos) {
        List<InnerLotto> responseLottos = lottos.getLottos().stream()
                .map(lotto -> InnerLotto.of(lotto.getNumbers()))
                .toList();
        return new ResponseLottosDto(responseLottos);
    }

    public long getLottoCount() {
        return responseLottos.size();
    }

    public List<InnerLotto> getResponseLottos() {
        return responseLottos;
    }

    public static class InnerLotto {
        private final List<Integer> numbers;

        private InnerLotto(List<Integer> numbers) {
            this.numbers = numbers;
        }

        private static InnerLotto of(List<Integer> numbers) {
            return new InnerLotto(numbers);
        }

        public List<Integer> getNumbers() {
            return numbers;
        }
    }
}
