package lotto.dto;

import java.util.Map;
import lotto.Rank;

public class WinningStatisticsDto {
    private final Map<Rank, Integer> rankAndCount;
    private final double rateOfReturn;

    public WinningStatisticsDto(Map<Rank, Integer> rankAndCount, double rateOfReturn) {
        this.rankAndCount = rankAndCount;
        this.rateOfReturn = rateOfReturn;
    }

    public Map<Rank, Integer> getRankAndCount() {
        return rankAndCount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
