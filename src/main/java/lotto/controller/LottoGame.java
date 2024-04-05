package lotto.controller;

import lotto.model.*;

public class LottoGame {
    private final LottoMachine lottoMachine;

    public LottoGame(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoTickets buy(int purchaseAmount) {
        return lottoMachine.buy(new PurchaseAmount(purchaseAmount));
    }

    public LottoWinningNumbers raffle(String lottos, int bonus) {
        return new LottoWinningNumbers(lottos, bonus);
    }

    public LottoResult getResult(LottoTickets tickets, LottoWinningNumbers winningNumbers) {
        return tickets.getWinningResult(winningNumbers);
    }
}
