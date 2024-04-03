package lotto;

import lotto.model.*;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoGameTest {
    @Test
    void 구매_금액과_당첨_번호를_받아서_로또_게임을_생성한다() {
        int purchaseAmount = 1000;
        String lottos = "1, 2, 3, 4, 5, 6";
        int bonus = 7;

        assertDoesNotThrow(() -> new LottoGame(purchaseAmount, lottos, bonus));
    }

    @Test
    void 로또_게임에서_1등에_당첨된다() {
        LottoTicketGeneratable generator = new LottoTicketGeneratable() {
            @Override
            public LottoTicket generate() {
                return new LottoTicket(Stream.of(1, 2, 3, 4, 5, 6)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()));
            }
        };
        LottoGame lottoGame = new LottoGame(1000, "1, 2, 3, 4, 5, 6", 7);

        assertThat(lottoGame.raffle(new LottoMachine(generator)).calculateTotalPrize()).isEqualTo(LottoRank.FIRST.getPrize());
    }

    @Test
    void 로또_게임에서_당첨되지_않는다() {
        LottoTicketGeneratable generator = new LottoTicketGeneratable() {
            @Override
            public LottoTicket generate() {
                return new LottoTicket(Stream.of(7, 8, 9, 10, 11, 12)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()));
            }
        };
        LottoGame lottoGame = new LottoGame(1000, "1, 2, 3, 4, 5, 6", 7);

        LottoResult result = lottoGame.raffle(new LottoMachine(generator));
        assertAll(
                () -> assertThat(result.calculateTotalPrize()).isEqualTo(0),
                () -> assertThat(result.calculateReturnRate()).isEqualTo(0.0F)
        );
    }
}
