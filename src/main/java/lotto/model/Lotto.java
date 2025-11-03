package lotto.model;

import static lotto.validation.ModelValidation.validateDuplicateNumber;
import static lotto.validation.ModelValidation.validateLottoNumberCount;
import static lotto.validation.ModelValidation.validateLottoNumberRange;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateLottoNumberRange(numbers);
        validateDuplicateNumber(numbers);

        this.numbers = numbers;
    }

    public static Lotto automaticLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
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
