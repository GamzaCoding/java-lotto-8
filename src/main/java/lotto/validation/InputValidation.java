package lotto.validation;

public class InputValidation {

    public static void validateNumberValue(String inputLottoPurchaseMoney) {
        if (!inputLottoPurchaseMoney.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자를 입력해야 합니다.");
        }
    }

    public static void validateNegative(String inputLottoPurchaseMoney) {
        if (Integer.parseInt(inputLottoPurchaseMoney) < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 음수를 입력할 수 없습니다.");
        }
    }

    public static void validateDivisibleByThousand(String inputLottoPurchaseMoney) {
        if (Integer.parseInt(inputLottoPurchaseMoney) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야합니다.");
        }
    }

    public static void validateZeroNumber(String inputLottoPurchaseMoney) {
        if (Integer.parseInt(inputLottoPurchaseMoney) == 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0원을 입력할 수 없습니다.");
        }
    }

    public static void validateWinningNumberFormat(String inputWinningNumber) {
        if (inputWinningNumber.matches("^\\d+(\\s*,\\s*\\d+){5}$")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 당첨 번호로 입력 양식이 틀렸습니다.");
    }

    public static void validateBonusNumberValue(String inputBonusNumber) {
        if (inputBonusNumber.matches("\\d+")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해야 합니다.");
    }

    public static void validateBonusNegative(String inputBonusNumber) {
        if (Integer.parseInt(inputBonusNumber) < 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 음수를 입력할 수 없습니다.");
        }
    }

    public static void validateZeroBonusNumber(String inputBonusNumber) {
        if (Integer.parseInt(inputBonusNumber) == 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 0원을 입력할 수 없습니다.");
        }
    }
}
