package lotto;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumberNotInWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(String winningNumbers, int bonusNumber) {
        List<String> winningNumberListString = Arrays.asList(winningNumbers.split(","));
        List<Integer> winningNumberListInteger = winningNumberListString.stream().map(Integer::parseInt).toList();
        return new WinningLotto(winningNumberListInteger, bonusNumber);
    }

    public int calculateMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean checkBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void validateBonusNumberNotInWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 로또 번호는 겹치면 안됩니다.");
        }
    }
}
