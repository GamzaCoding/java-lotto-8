package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RateOfReturnService {

    public static double calculateRateOfReturn(long inputLottoPurchaseMoney, long totalLottoWinningAmount) {
        double rateOfReturn = (double) (totalLottoWinningAmount - inputLottoPurchaseMoney) / (inputLottoPurchaseMoney);
        BigDecimal rateOfReturnBigDe = new BigDecimal(rateOfReturn).setScale(1, RoundingMode.HALF_EVEN);

        return rateOfReturnBigDe.doubleValue();
    }
}
