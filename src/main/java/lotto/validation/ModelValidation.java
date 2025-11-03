package lotto.validation;

import static lotto.util.Constant.MAX_NUMBER;
import static lotto.util.Constant.MIN_NUMBER;
import static lotto.util.Constant.LOTTO_SIZE;
import static lotto.validation.ErrorMessageConstant.ERROR;

import java.util.List;
import java.util.Set;

public class ModelValidation {

    public static void validateBonusNumberNotInWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR + "보너스 번호와 당첨 로또 번호는 겹치면 안됩니다.");
        }
    }

    public static void validateLottoNumberRange(List<Integer> numbers) {
        if (isCorrectRange(numbers)) {
            return;
        }
        throw new IllegalArgumentException(ERROR + "로또 번호는 1~45 사이어야 합니다.");
    }

    public static void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR + "로또 번호는 6개여야 합니다.");
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException(ERROR + "로또 번호는 중복될 수 없습니다.");
        }
    }

    private static boolean isCorrectRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> MIN_NUMBER <= number && number <= MAX_NUMBER);
    }
}
