package lotto;

import java.util.List;

public class LottoResult {
    private final List<LottoRank> lottoRanks;
    private final PurchaseAmount totalPurchaseAmount;

    public LottoResult(List<LottoRank> lottoRanks, PurchaseAmount totalPurchaseAmount) {
        this.lottoRanks = lottoRanks;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public long calculateTotalPrize() {
        return lottoRanks.stream()
                .mapToLong(LottoRank::getPrize)
                .sum();
    }

    public float calculateReturnRate() {
        return (float) calculateTotalPrize() / totalPurchaseAmount.getPurchaseAmount();
    }
}
