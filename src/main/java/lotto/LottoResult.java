package lotto;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoRanks, that.lottoRanks) && Objects.equals(totalPurchaseAmount, that.totalPurchaseAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoRanks, totalPurchaseAmount);
    }
}
