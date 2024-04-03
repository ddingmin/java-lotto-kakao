package lotto;

import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = Input.getPurchaseAmount();
        LottoGame lottoGame = new LottoGame(purchaseAmount);
        Output.printPurchaseAmount(lottoGame.getTicketCount());

        LottoTicketGeneratable generator = new LottoTicketGenerator();
        Output.printLottoTickets(lottoGame.buy(new LottoMachine(generator)));

        String lottos = Input.getWinningNumbers();
        int bonus = Input.getBonusNumber();
        lottoGame.raffle(lottos, bonus);

        Output.printResult(lottoGame.getResult());
    }
}
