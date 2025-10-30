package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        validateLottoNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        if (!isCorrectRange(numbers)) {
            throw  new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이어야 합니다.");
        }
    }

    private boolean isCorrectRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> 1 <= number && number <= 45);
    }
}
