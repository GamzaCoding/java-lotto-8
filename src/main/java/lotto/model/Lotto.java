package lotto.model;

import static lotto.validation.ModelValidation.validateDuplicateNumber;
import static lotto.validation.ModelValidation.validateLottoNumberCount;
import static lotto.validation.ModelValidation.validateLottoNumberRange;

import java.util.List;
import lotto.model.strategy.LottoNumberStrategy;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateLottoNumberRange(numbers);
        validateDuplicateNumber(numbers);

        this.numbers = numbers;
    }

    public static Lotto automaticLotto(LottoNumberStrategy lottoNumberStrategy) {
        List<Integer> lottoNumbers = lottoNumberStrategy.generateNumbers();
        return new Lotto(lottoNumbers.stream().sorted().toList());
    }

    public static Lotto manualLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int countMatchWith(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public boolean checkBonusWith(WinningLotto winningLotto) {
        return numbers.contains(winningLotto.getBonusNumber());
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
