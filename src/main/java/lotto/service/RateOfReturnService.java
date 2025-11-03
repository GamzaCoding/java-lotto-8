package lotto.service;

import static lotto.util.Constant.AMOUNT_OF_ONE_LOTTO;
import static lotto.util.Constant.PERCENT;
import static lotto.util.Constant.TENTHS;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.dto.ResponseLottosDto;
import lotto.dto.WinningStatisticsDto;

public class RateOfReturnService {

    public double calculate(WinningStatisticsDto winningStatisticsDto, ResponseLottosDto responseLottosDto) {
        long totalRevenue = calculateTotalRevenue(winningStatisticsDto);
        long totalSpent = responseLottosDto.getLottoCount() * AMOUNT_OF_ONE_LOTTO;
        return calculateRateOfReturn(totalSpent, totalRevenue);
    }

    private long calculateTotalRevenue(WinningStatisticsDto winningStatisticsDto) {
        return winningStatisticsDto.rankCountStatistics().entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().prizeMoney() * entry.getValue())
                .sum();
    }

    private double calculateRateOfReturn(long totalSpent, long totalRevenue) {
        double rateOfReturn = (double) totalRevenue / totalSpent * PERCENT;
        return BigDecimal.valueOf(rateOfReturn)
                .setScale(TENTHS, RoundingMode.HALF_EVEN)
                .doubleValue();
    }
}
