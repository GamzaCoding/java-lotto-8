package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    ZER0(0,0) // 이 부분도 추가로 확인해야 한다.
    ;

    private final int count;
    private final int prizeMoney;

    Rank(int count, int prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public int getCount() {
        return count;
    }

    public int prizeMoney() {
        return prizeMoney;
    }

    public static Rank findByCount(int count, boolean bonusMatch) {
        if (count == 5 && bonusMatch) {
            return Rank.SECOND;
        }

        for(Rank rank : values()) {
            if(rank.count == count) {
                return rank;
            }
        }
        return Rank.ZER0;
    }
}
