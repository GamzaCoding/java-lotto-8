package lotto.validation;

import static lotto.constant.Constant.THOUSAND_NUMBER;
import static lotto.constant.Constant.ZERO_MONEY;
import static lotto.constant.Constant.ZERO_NUMBER;
import static lotto.constant.ErrorMessageConstant.ERROR;
import static lotto.constant.ErrorMessageConstant.ERROR_BONUS_NUMBER_NEGATIVE;
import static lotto.constant.ErrorMessageConstant.ERROR_BONUS_NUMBER_NOT_NUMBER;
import static lotto.constant.ErrorMessageConstant.ERROR_BONUS_NUMBER_ZERO;
import static lotto.constant.ErrorMessageConstant.ERROR_PURCHASE_MONEY_NEGATIVE;
import static lotto.constant.ErrorMessageConstant.ERROR_PURCHASE_MONEY_NOT_DIVISIBLE_BY_THOUSAND;
import static lotto.constant.ErrorMessageConstant.ERROR_PURCHASE_MONEY_NOT_NUMBER;
import static lotto.constant.ErrorMessageConstant.ERROR_PURCHASE_MONEY_ZERO;
import static lotto.constant.ErrorMessageConstant.ERROR_WINNING_NUMBER_FORMAT_INVALID;

public class InputValidation {

    public static final String NUMBER_REGEX = "\\d+";
    public static final String WINNING_NUMBER_REGEX = "^\\d+(\\s*,\\s*\\d+){5}$";

    public static void validateNumberValue(String inputLottoPurchaseMoney) {
        if (inputLottoPurchaseMoney.matches(NUMBER_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(ERROR + ERROR_PURCHASE_MONEY_NOT_NUMBER);
    }

    public static void validateNegative(String inputLottoPurchaseMoney) {
        if (parseInt(inputLottoPurchaseMoney) < ZERO_MONEY) {
            throw new IllegalArgumentException(ERROR + ERROR_PURCHASE_MONEY_NEGATIVE);
        }
    }

    public static void validateDivisibleByThousand(String inputLottoPurchaseMoney) {
        if (parseInt(inputLottoPurchaseMoney) % THOUSAND_NUMBER != ZERO_NUMBER) {
            throw new IllegalArgumentException(ERROR + ERROR_PURCHASE_MONEY_NOT_DIVISIBLE_BY_THOUSAND);
        }
    }

    public static void validateZeroNumber(String inputLottoPurchaseMoney) {
        if (parseInt(inputLottoPurchaseMoney) == ZERO_MONEY) {
            throw new IllegalArgumentException(ERROR + ERROR_PURCHASE_MONEY_ZERO);
        }
    }

    public static void validateWinningNumberFormat(String inputWinningNumber) {
        if (inputWinningNumber.matches(WINNING_NUMBER_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(ERROR + ERROR_WINNING_NUMBER_FORMAT_INVALID);
    }

    public static void validateBonusNumberValue(String inputBonusNumber) {
        if (inputBonusNumber.matches(NUMBER_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(ERROR + ERROR_BONUS_NUMBER_NOT_NUMBER);
    }

    public static void validateBonusNegative(String inputBonusNumber) {
        if (parseInt(inputBonusNumber) < ZERO_NUMBER) {
            throw new IllegalArgumentException(ERROR + ERROR_BONUS_NUMBER_NEGATIVE);
        }
    }

    public static void validateZeroBonusNumber(String inputBonusNumber) {
        if (Integer.parseInt(inputBonusNumber) == ZERO_NUMBER) {
            throw new IllegalArgumentException(ERROR + ERROR_BONUS_NUMBER_ZERO);
        }
    }

    private static int parseInt(String number) {
        return Integer.parseInt(number);
    }
}
