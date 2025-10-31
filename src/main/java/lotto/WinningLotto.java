package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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


        List<Integer> winningNumberListInteger = winningNumberListString.stream()
                .map(String::strip)
                .map(Integer::parseInt).toList();
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

    public Rank calculateRank(Lotto lotto) {
        int matchCount = calculateMatchCount(lotto);
        boolean matchBonus = checkBonus(lotto);
        return Rank.findByCount(matchCount,matchBonus);
    }

    public Map<Rank, Integer> giveRankAndCount(Lottos lottos) {
        Map <Rank, Integer> rankAndCount = new LinkedHashMap<>();

        rankAndCount.put(Rank.FIFTH, 0);
        rankAndCount.put(Rank.FOURTH, 0);
        rankAndCount.put(Rank.THIRD, 0);
        rankAndCount.put(Rank.SECOND, 0);
        rankAndCount.put(Rank.FIRST, 0);

        lottos.getLottos().stream()
                .forEach(lotto -> rankAndCount.merge(calculateRank(lotto),1, Integer::sum));

        rankAndCount.remove(Rank.ZER0);

        return rankAndCount;
    }
}
