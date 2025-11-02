package lotto.view;

import static lotto.validation.InputValidation.validateDivisibleByThousand;
import static lotto.validation.InputValidation.validateNegative;
import static lotto.validation.InputValidation.validateNumberValue;
import static lotto.validation.InputValidation.validateWinningNumberFormat;
import static lotto.validation.InputValidation.validateZeroNumber;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputPurchaseAmount() {
        String input = Console.readLine();
        validateNumberValue(input);
        validateNegative(input);
        validateDivisibleByThousand(input);
        validateZeroNumber(input);
        return input;
    }

    public String inputWinningNumber() {
        String input = Console.readLine();
        validateWinningNumberFormat(input);
        return input;
    }

    public String inputBonusNumber() {
        return Console.readLine();
    }
}
