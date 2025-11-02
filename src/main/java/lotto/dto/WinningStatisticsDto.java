package lotto.dto;

import java.util.Map;
import lotto.model.Rank;

public class WinningStatisticsDto {
    private final Map<Rank, Integer> rankAndCount;

    public WinningStatisticsDto(Map<Rank, Integer> rankAndCount) {
        this.rankAndCount = rankAndCount;
    }

    public Map<Rank, Integer> getRankAndCount() {
        return rankAndCount;
    }
}
