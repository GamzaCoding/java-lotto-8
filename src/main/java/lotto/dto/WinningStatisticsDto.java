package lotto.dto;

import java.util.List;
import java.util.Map;
import lotto.model.Rank;

public record WinningStatisticsDto(List<WinningRankInfo> winningRankInfos) {

    public static WinningStatisticsDto from(Map<Rank, Integer> rankCountStatistics) {
        List<WinningRankInfo> winningRankInfos = rankCountStatistics.entrySet().stream()
                .map((rankEntry ->
                        WinningRankInfo.from(rankEntry.getKey(), rankEntry.getValue())))
                .toList();

        return new WinningStatisticsDto(winningRankInfos);
    }

    public record WinningRankInfo(int matchCount, long prizeMoney, int count, boolean bonus) {

        public static WinningRankInfo from(Rank rank, int count) {
            boolean bonus = Rank.isSecond(rank);
            return new WinningRankInfo(rank.getMatchCount(), rank.prizeMoney(), count, bonus);
        }
    }
}
