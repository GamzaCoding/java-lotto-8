package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.dto.ResponseLottosDto;
import lotto.dto.WinningStatisticsDto;

public class RateOfReturnService {
    public static final int AMOUNT_OF_ONE_LOTTO = 1_000;
    public static final int PERCENT = 100;

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
                .setScale(1, RoundingMode.HALF_EVEN)
                .doubleValue();
    }
}
