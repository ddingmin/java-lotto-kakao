package lotto;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == FIRST.matchCount) {
            return matchBonus ? SECOND : FIRST;
        }
        for (LottoRank lottoRank : values()) {
            if (lottoRank.matchCount == matchCount) {
                return lottoRank;
            }
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }
}
