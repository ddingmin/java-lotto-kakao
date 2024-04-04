package lotto;

import lotto.controller.LottoGame;
import lotto.model.*;
import lotto.model.dto.LottoTicketDto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = Input.getPurchaseAmount();
        LottoGame lottoGame = new LottoGame(purchaseAmount);
        LottoTicketGeneratable generator = new LottoTicketGenerator();
        List<LottoTicketDto> boughtTickets = lottoGame.buy(new LottoMachine(generator));

        Output.printPurchaseAmount(boughtTickets.size());
        Output.printLottoTickets(boughtTickets);

        String lottos = Input.getWinningNumbers();
        int bonus = Input.getBonusNumber();
        lottoGame.raffle(lottos, bonus);

        Output.printResult(lottoGame.getResult());
    }
}
