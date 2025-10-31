package lotto.validation;

public class Validation {

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
}
