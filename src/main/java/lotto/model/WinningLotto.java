package lotto.model;

import static lotto.validation.ModelValidation.validateBonusNumberNotInWinningNumbers;
import static lotto.validation.ModelValidation.validateLottoNumberRange;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumberNotInWinningNumbers(winningNumbers, bonusNumber);
        validateLottoNumberRange(winningNumbers);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public static WinningLotto makeWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
