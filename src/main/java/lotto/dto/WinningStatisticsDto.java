package lotto.dto;

import java.util.Map;
import lotto.model.Rank;

public record WinningStatisticsDto(Map<Rank, Integer> rankCountStatistics) {

    public static WinningStatisticsDto of(Map<Rank, Integer> rankCountStatistics) {
        return new WinningStatisticsDto(Map.copyOf(rankCountStatistics));
    }
}
