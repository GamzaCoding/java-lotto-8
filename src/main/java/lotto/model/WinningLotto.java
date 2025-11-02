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

    public int calculateMatchCount(Lotto lotto) { // 이부분에 대해서 쫌 더 고민해보자, lotto를 알고 있는게 맞나?
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean checkBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
