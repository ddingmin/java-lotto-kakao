package lotto;

import lotto.controller.LottoGame;
import lotto.model.*;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoGameTest {
    @Test
    void 로또_게임을_생성한다() {
        LottoMachine lottoMachine = new LottoMachine(new LottoTicketGenerator());

        assertDoesNotThrow(() -> new LottoGame(lottoMachine));
    }

    @Test
    void 구매_금액을_받아서_구매_가능한_수의_로또_티겟을_구매한다() {
        LottoMachine lottoMachine = new LottoMachine(new LottoTicketGenerator());
        LottoGame lottoGame = new LottoGame(lottoMachine);

        LottoTickets boughtTickets = lottoGame.buy(1000);

        assertThat(boughtTickets.getSize()).isEqualTo(1000 / LottoTicket.PRICE);
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
        LottoGame lottoGame = new LottoGame(new LottoMachine(generator));
        LottoTickets boughtTickets = lottoGame.buy(1000);
        LottoWinningNumbers winningNumbers = lottoGame.raffle("1, 2, 3, 4, 5, 6", 7);

        LottoResult result = lottoGame.getResult(boughtTickets, winningNumbers);

        assertThat(result.calculateTotalPrize()).isEqualTo(LottoRank.FIRST.getPrize());
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
        LottoGame lottoGame = new LottoGame(new LottoMachine(generator));
        LottoTickets boughtTickets = lottoGame.buy(1000);
        LottoWinningNumbers winningNumbers = lottoGame.raffle("1, 2, 3, 4, 5, 6", 7);

        LottoResult result = lottoGame.getResult(boughtTickets, winningNumbers);

        assertAll(
                () -> assertThat(result.calculateTotalPrize()).isEqualTo(0),
                () -> assertThat(result.calculateReturnRate()).isEqualTo(0.0F)
        );
    }
}
