package lotto.validation;

import static lotto.util.Constant.THOUSAND_NUMBER;
import static lotto.util.Constant.ZERO_MONEY;
import static lotto.util.Constant.ZERO_NUMBER;
import static lotto.validation.ErrorMessageConstant.*;

public class InputValidation {

    public static final String NUMBER_REGEX = "\\d+";
    public static final String WINNING_NUMBER_REGEX = "^\\d+(\\s*,\\s*\\d+){5}$";

    public static void validateNumberValue(String inputLottoPurchaseMoney) {
        if (inputLottoPurchaseMoney.matches(NUMBER_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(ERROR + "로또 구입 금액은 숫자를 입력해야 합니다.");
    }

    public static void validateNegative(String inputLottoPurchaseMoney) {
        if (parseInt(inputLottoPurchaseMoney) < ZERO_MONEY) {
            throw new IllegalArgumentException(ERROR + "로또 구입 금액은 음수를 입력할 수 없습니다.");
        }
    }

    public static void validateDivisibleByThousand(String inputLottoPurchaseMoney) {
        if (parseInt(inputLottoPurchaseMoney) % THOUSAND_NUMBER != ZERO_NUMBER) {
            throw new IllegalArgumentException(ERROR + "로또 구입 금액은 1000원 단위로 입력해야합니다.");
        }
    }

    public static void validateZeroNumber(String inputLottoPurchaseMoney) {
        if (parseInt(inputLottoPurchaseMoney) == ZERO_MONEY) {
            throw new IllegalArgumentException(ERROR + "로또 구입 금액은 0원을 입력할 수 없습니다.");
        }
    }

    public static void validateWinningNumberFormat(String inputWinningNumber) {
        if (inputWinningNumber.matches(WINNING_NUMBER_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(ERROR + "당첨 번호로 입력 양식이 틀렸습니다.");
    }

    public static void validateBonusNumberValue(String inputBonusNumber) {
        if (inputBonusNumber.matches(NUMBER_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(ERROR + "보너스 번호는 숫자를 입력해야 합니다.");
    }

    public static void validateBonusNegative(String inputBonusNumber) {
        if (parseInt(inputBonusNumber) < ZERO_NUMBER) {
            throw new IllegalArgumentException(ERROR + "보너스 번호는 음수를 입력할 수 없습니다.");
        }
    }

    public static void validateZeroBonusNumber(String inputBonusNumber) {
        if (Integer.parseInt(inputBonusNumber) == ZERO_NUMBER) {
            throw new IllegalArgumentException(ERROR + "보너스 번호는 0을 입력할 수 없습니다.");
        }
    }

    private static int parseInt(String number) {
        return Integer.parseInt(number);
    }
}
