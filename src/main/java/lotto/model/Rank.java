package lotto.model;

import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOTHING(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    Rank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static boolean isSecond(Rank rank) {
        return rank == Rank.SECOND;
    }

    public static List<Rank> getRanks() {
        return List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH);
    }

    public static Rank findByCount(int matchCount, boolean bonusMatch) {
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        }
        if (matchCount == SECOND.matchCount && bonusMatch) {
            return SECOND;
        }
        if (matchCount == SECOND.matchCount) {
            return THIRD;
        }
        if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        }
        if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }
        return NOTHING;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int prizeMoney() {
        return prizeMoney;
    }
}
