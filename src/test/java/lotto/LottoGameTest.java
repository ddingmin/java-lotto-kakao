package lotto;

import lotto.model.*;
import lotto.model.dto.LottoResultDto;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoGameTest {
    @Test
    void 구매_금액을_받아서_로또_게임을_생성한다() {
        int purchaseAmount = 1000;

        assertDoesNotThrow(() -> new LottoGame(purchaseAmount));
    }

    @Test
    void 구매_금액을_받아서_구매_가능한_수의_로또_티겟을_구매한다() {
        LottoGame lottoGame = new LottoGame(1000);

        assertThat(lottoGame.getTicketCount()).isEqualTo(1000 / LottoTicket.PRICE);
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
        LottoGame lottoGame = new LottoGame(1000);
        lottoGame.buy(new LottoMachine(generator));
        lottoGame.raffle("1, 2, 3, 4, 5, 6", 7);

        LottoResultDto result = lottoGame.getResult();
        assertThat(result.getTotalPrize()).isEqualTo(LottoRank.FIRST.getPrize());
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
        LottoGame lottoGame = new LottoGame(1000);
        lottoGame.buy(new LottoMachine(generator));
        lottoGame.raffle("1, 2, 3, 4, 5, 6", 7);
        LottoResultDto result = lottoGame.getResult();
        assertAll(
                () -> assertThat(result.getTotalPrize()).isEqualTo(0),
                () -> assertThat(result.getReturnRate()).isEqualTo(0.0F)
        );
    }
}
