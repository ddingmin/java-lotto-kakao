package lotto;

import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoResultTest {
    @Test
    void 로또_Rank들과_구매금액을_받아서_생성한다() {
        List<LottoRank> ranks = List.of(
                LottoRank.FIRST,
                LottoRank.FIRST,
                LottoRank.SECOND,
                LottoRank.THIRD,
                LottoRank.FOURTH,
                LottoRank.FIFTH
        );

        Assertions.assertDoesNotThrow(() -> new LottoResult(ranks, new PurchaseAmount(14_000L)));
    }

    @ParameterizedTest
    @ValueSource(longs = {0, -1})
    void 구매금액이_0이하면_예외를_던진다(long purchaseAmount) {
        List<LottoRank> ranks = List.of(LottoRank.FIRST);

        assertThatThrownBy(() -> new LottoResult(ranks, new PurchaseAmount(purchaseAmount)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 상금_총액을_계산한다() {
        List<LottoRank> ranks = List.of(
                LottoRank.FIRST,
                LottoRank.FIRST,
                LottoRank.SECOND
        );
        LottoResult result = new LottoResult(ranks, new PurchaseAmount(14_000L));
        assertThat(result.calculateTotalPrize()).isEqualTo(4_030_000_000L);
    }

    @Test
    void 수익률을_계산한다() {
        List<LottoRank> ranks = List.of(
                LottoRank.FIRST,
                LottoRank.FIRST,
                LottoRank.SECOND
        );
        LottoResult result = new LottoResult(ranks, new PurchaseAmount(10_000L));
        assertThat(result.calculateReturnRate()).isEqualTo(403_000L);
    }
}
