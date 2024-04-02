package lotto;

import java.util.List;

public class LottoResult {
    private final List<LottoRank> lottoRanks;
    private final Long totalPurchaseAmount;

    public LottoResult(List<LottoRank> lottoRanks, Long totalPurchaseAmount) {
        validate(totalPurchaseAmount);
        this.lottoRanks = lottoRanks;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    private void validate(Long totalPurchaseAmount) {
        if (totalPurchaseAmount <= 0) {
            throw new IllegalArgumentException("구매 금액은 0보다 커야 합니다.");
        }
    }

    public long calculateTotalPrize() {
        return lottoRanks.stream()
                .mapToLong(LottoRank::getPrize)
                .sum();
    }

    public float calculateReturnRate() {
        return (float) calculateTotalPrize() / totalPurchaseAmount;
    }
}
