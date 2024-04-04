package lotto;

import lotto.controller.LottoGame;
import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;

public class Main {
    public static void main(String[] args) {
        LottoTicketGeneratable generator = new LottoTicketGenerator();
        LottoGame lottoGame = new LottoGame(new LottoMachine(generator));

        int purchaseAmount = Input.getPurchaseAmount();
        LottoTickets boughtTickets = lottoGame.buy(purchaseAmount);

        Output.printPurchaseAmount(boughtTickets.getSize());
        Output.printLottoTickets(boughtTickets);

        String lottos = Input.getWinningNumbers();
        int bonus = Input.getBonusNumber();
        LottoWinningNumbers winningNumbers = lottoGame.raffle(lottos, bonus);

        LottoResult result = lottoGame.getResult(boughtTickets, winningNumbers);
        Output.printResult(result);
    }
}
