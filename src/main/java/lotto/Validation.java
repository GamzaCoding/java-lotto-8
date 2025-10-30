package lotto;

public class Validation {

    public static void validateNumberValue(String inputLottoPurchaseMoney) {
        if (!inputLottoPurchaseMoney.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자를 입력해야 합니다.");
        }
    }
}
