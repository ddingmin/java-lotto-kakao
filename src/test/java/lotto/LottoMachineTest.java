package lotto;

import lotto.model.LottoMachine;
import lotto.model.LottoTicket;
import lotto.model.LottoTicketGenerator;
import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    void 구매_금액을_받아_로또를_발급한다() {
        LottoTicketGenerator generator = new LottoTicketGenerator();
        LottoMachine lottoMachine = new LottoMachine(generator);

        assertThat(lottoMachine.buy(new PurchaseAmount(5000L)).getSize()).isEqualTo(5000 / LottoTicket.PRICE);
    }
}
