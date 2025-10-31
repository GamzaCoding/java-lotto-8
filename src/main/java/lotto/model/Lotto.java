package lotto.model;

import static lotto.validation.ModelValidation.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateLottoNumberRange(numbers);
        validateDuplicateNumber(numbers);

        this.numbers = numbers;
    }

    public static Lotto createRandomLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers.stream().sorted().toList());
    }

    public static Lotto makeLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
