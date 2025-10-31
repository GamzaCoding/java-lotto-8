package lotto.view;

import static lotto.validation.Validation.*;

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
        return Console.readLine();
    }

    public String inputBonusNumber() {
        return Console.readLine();
    }
}
