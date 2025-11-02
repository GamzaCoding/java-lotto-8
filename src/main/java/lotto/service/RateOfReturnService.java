package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.dto.ResponseLottosDto;
import lotto.dto.WinningStatisticsDto;

public class RateOfReturnService {

    public double calculate(WinningStatisticsDto winningStatisticsDto, ResponseLottosDto responseLottosDto) {
        long totalWinningAmount = calculateTotalWinningAmount(winningStatisticsDto);
        long inputPurchaseAmount = responseLottosDto.getLottoCount() * 1_000; // 이건 진짜 아니다.
        return calculateRateOfReturn(inputPurchaseAmount, totalWinningAmount);
    }

    private long calculateTotalWinningAmount(WinningStatisticsDto winningStatisticsDto) {
       return winningStatisticsDto.getRankAndCount().entrySet().stream()
               .mapToLong(entry -> (long) entry.getKey().prizeMoney() * entry.getValue())
               .sum();
    }

    private double calculateRateOfReturn(long inputLottoPurchaseMoney, long totalLottoWinningAmount) {
        double rateOfReturn = (double) totalLottoWinningAmount / inputLottoPurchaseMoney * 100;
        BigDecimal rateOfReturnBigDe = new BigDecimal(rateOfReturn).setScale(1, RoundingMode.HALF_EVEN);

        return rateOfReturnBigDe.doubleValue();
    }
}
