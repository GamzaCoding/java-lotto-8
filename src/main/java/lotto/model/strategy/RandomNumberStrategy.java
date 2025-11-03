package lotto.model.strategy;

import static lotto.constant.Constant.LOTTO_SIZE;
import static lotto.constant.Constant.MAX_NUMBER;
import static lotto.constant.Constant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberStrategy implements LottoNumberStrategy{
    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
    }
}
