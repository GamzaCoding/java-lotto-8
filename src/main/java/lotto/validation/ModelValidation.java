package lotto.validation;

import static lotto.constant.Constant.MAX_NUMBER;
import static lotto.constant.Constant.MIN_NUMBER;
import static lotto.constant.Constant.LOTTO_SIZE;
import static lotto.constant.ErrorMessageConstant.ERROR_BONUS_NUMBER_NOT_IN_WINNING_NUMBERS;
import static lotto.constant.ErrorMessageConstant.ERROR;
import static lotto.constant.ErrorMessageConstant.ERROR_LOTTO_NUMBER_COUNT;
import static lotto.constant.ErrorMessageConstant.ERROR_LOTTO_NUMBER_DUPLICATE;
import static lotto.constant.ErrorMessageConstant.ERROR_LOTTO_NUMBER_RANGE;

import java.util.List;
import java.util.Set;

public class ModelValidation {

    public static void validateBonusNumberNotInWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR + ERROR_BONUS_NUMBER_NOT_IN_WINNING_NUMBERS);
        }
    }

    public static void validateLottoNumberRange(List<Integer> numbers) {
        if (isCorrectRange(numbers)) {
            return;
        }
        throw new IllegalArgumentException(ERROR + ERROR_LOTTO_NUMBER_RANGE);
    }

    public static void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR + ERROR_LOTTO_NUMBER_COUNT);
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException(ERROR + ERROR_LOTTO_NUMBER_DUPLICATE);
        }
    }

    private static boolean isCorrectRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> MIN_NUMBER <= number && number <= MAX_NUMBER);
    }
}
